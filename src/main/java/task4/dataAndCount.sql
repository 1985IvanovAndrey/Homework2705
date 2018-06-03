-- 4)Выбрать данные в виде
-- Дата|Кол-во звонков

SELECT date,count(id_service) FROM table4task4 GROUP BY date;