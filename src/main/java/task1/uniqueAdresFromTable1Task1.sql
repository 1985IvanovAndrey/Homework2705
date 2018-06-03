-- •	Каким запросом выбрать перечень уникальных адресов из таблицы ?

SELECT adres FROM table1task1 GROUP BY adres HAVING COUNT(*)=1
