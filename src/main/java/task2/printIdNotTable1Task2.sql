-- 3) Показать клиентов которых нет в первой таблице,  но по ним есть доходы.
select table2task2.id_klient,SUM(summa_salary) from table2task2 where table2task2.id_klient not in (select id_klient from table1task2) GROUP BY table2task2.id_klient,table2task2.summa_salary;
