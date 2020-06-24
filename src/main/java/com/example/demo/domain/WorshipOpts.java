package com.example.demo.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "valueOf", accessorMethod = "getValue")
public enum WorshipOpts {
	worshipType1(1, "葬式"), worshipType2(2, "寺参り"), worshipType3(3, "初七日"), worshipType4(4, "七日七日"),
	worshipType5(5, "一周忌"), worshipType6(6, "三回忌"), worshipType7(7, "七回忌");

	private final int code;
	private final String label;
	
	WorshipOpts(Integer code, String label) {
		this.code = code;
		this.label = label;
	}

	public static WorshipOpts valueOf(Integer code) {
		switch (code) {
		case 1:
			return worshipType1;
		case 2:
			return worshipType2;
		case 3:
			return worshipType3;
		case 4:
			return worshipType4;
		case 5:
			return worshipType5;
		case 6:
			return worshipType6;
		case 7:
			return worshipType7;
		default:
			throw new IllegalArgumentException("存在しないお参りの種類です" + code);
		}
	}
	
	public Integer getValue() {
		return this.code;
	}
	
	public String getLabel() {
		return this.label;
	}
}
