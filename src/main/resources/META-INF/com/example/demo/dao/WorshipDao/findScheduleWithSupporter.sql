select s.supporter_name, w.worship_opts, w.schedule, w.remark
from supporter as s
inner join worship as w
on  s.supporter_id = w.supporter_id;