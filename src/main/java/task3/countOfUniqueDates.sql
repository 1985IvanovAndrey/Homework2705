-- 2) Добавить к запросу отображение кол-ва уникальных дат когда был доход по клиенту.
SELECT id_client,count(DISTINCT date) from table1task3 GROUP BY id_client;