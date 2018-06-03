-- 3)Выбрать данные в виде
-- Название службы| Последняя дата звонка|Кол-во звонков

SELECT name_service,max(date),count(name_service)FROM table1task4,table4task4 WHERE table1task4.id_service=table4task4.id_service GROUP BY name_service