select
    /*%expand*/*
from supporter
where supporter_id = /*supporterId*/'1'
/*%if supporterName != null*/
	AND supporter_name
	Like /* @infix(supporterName) */'supporterName'
/*%end*/


