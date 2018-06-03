-- 3) По предыдущему запросу  показать только тех клиентов у которых кол-во дат когда было поступление больше одной.
SELECT id_client,count(date) AS count_dates from table1task3 GROUP BY id_client HAVING count(date)>1;
