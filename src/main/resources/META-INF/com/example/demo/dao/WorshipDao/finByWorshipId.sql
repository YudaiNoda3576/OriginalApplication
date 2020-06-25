select s.supporter_name, w.worship_opts, w.schedule, w.remark, w.progress, w.worship_id
from supporter as s
inner join worship as w
on  s.supporter_id = w.supporter_id
where w.worship_id = /*worship_id*/'a'