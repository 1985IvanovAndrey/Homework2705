-- 1)Выбрать данные в виде
-- Название службы|ФИО оператора|ФИО клиента|Последняя дата звонка

SELECT name_service,fio_operatora,fio_client,max(date)FROM table1task4,table2task4,table3task4,table4task4 WHERE table1task4.id_service=table4task4.id_service AND table2task4.id_operator=table4task4.id_operator AND table3task4.id_client=table4task4.id_client GROUP BY name_service,fio_operatora,fio_client