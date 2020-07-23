select
    s.supporter_name, w.worship_opts, w.schedule, w.remark, w.progress, w.worship_id
from supporter as s
inner join worship as w
on  s.supporter_id = w.supporter_id
where 
/*%if supporterName != null*/
  s.supporter_name  Like /* @infix(supporterName) */'%野田%'
/*%end*/





