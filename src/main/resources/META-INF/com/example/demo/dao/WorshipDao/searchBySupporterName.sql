select
    s.supporter_name, w.worship_opts, w.schedule, w.remark, w.progress, w.worship_id
from supporter as s
inner join worship as w
on  s.supporter_id = w.supporter_id
where s.supporter_name = /*supporterName*/'野田雄大'
/*%if supporterName != null*/
	Like /* @infix(supporterName) */'supporterName'
/*%end*/


