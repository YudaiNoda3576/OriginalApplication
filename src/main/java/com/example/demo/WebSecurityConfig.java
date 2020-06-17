package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//セキュリティ設定用クラス
@EnableWebSecurity
@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{	
	
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
//		SQLを実行できるようにする
		@Autowired
		private DataSource dataSource;

		private static final String TEMPLE_SQL = "SELECT" 
				+ " temple_id,"  
				+ " password,"
				+ " true"
				+ " FROM"
				+ " temple"
				+ " WHERE"
				+ " temple_id = ?"; 
		
		
//		静的リソースを除外
//		静的リソース(webjars,cssなど)へのアクセスには、セキュリティを適用しない
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring()
			.antMatchers("/webjars/**", "/css/**");
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
	//　メソッドチェーンでリンク禁止先の条件を追加（メソッドチェーンでは上から順番に設定がされていく）
			http
			.authorizeRequests()
//			webjarsへのアクセスの許可
			.antMatchers("/webjars/**")
			.permitAll()
//			ログインページは直リンク可能
			.antMatchers("/login")
			.permitAll()
//			ユーザー登録画面は直リンク可能
			.antMatchers("/signup")
			.permitAll()
//			それ以外はリンク禁止
			.anyRequest()
			.authenticated();
			
//			ログイン処理
			http
			.formLogin()
//			ログイン処理のパス
			.loginProcessingUrl("/login")
//			ログインページの指定
			.loginPage("/login")
//			ログイン失敗時の遷移先
			.failureUrl("/login")
//			ログインページのID・nameタグのパラメーターと紐づく
			.usernameParameter("templeId")
//			ログインページのパスワード
			.passwordParameter("password")
//			ログイン成功時の遷移先
			.defaultSuccessUrl("/home", true);
//			ログアウト処理
			http
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login");
//			一時的にCSRF対策を無効に設定
//			http.csrf().disable();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(TEMPLE_SQL)
				.authoritiesByUsernameQuery("SELECT temple_id, role from temple where temple_id = ?")
				.passwordEncoder(passwordEncoder());
		}
		
	

}
