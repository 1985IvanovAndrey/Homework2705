-- 2)Выбрать данные в виде
-- Название службы|ФИО оператор|Последняя дата звонка

SELECT name_service,fio_operatora,max(date)FROM table1task4,table2task4,table4task4 WHERE table1task4.id_service=table4task4.id_service AND table2task4.id_operator=table4task4.id_operator GROUP BY name_service,fio_operatora