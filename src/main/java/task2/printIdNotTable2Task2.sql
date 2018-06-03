-- 4) Показать клиентов которые есть в первой таблице а во второй их нет.
SELECT * FROM table1task2 WHERE id_klient not IN (SELECT id_klient FROM table2task2)
