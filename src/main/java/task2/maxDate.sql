-- 2) Выбрать по каждому клиенту из первой таблицы последнюю дату получения дохода. 
-- Клиенты у которых дохода не было не показывать.

SELECT table1task2.id_klient,max(table2task2.data) FROM table1task2 JOIN table2task2 ON table1task2.id_klient=table2task2.id_klient GROUP BY table1task2.id_klient
