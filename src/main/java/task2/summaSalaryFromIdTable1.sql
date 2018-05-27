SELECT table1task2.id_klient,SUM(table2task2.summa_salary) FROM table1task2 LEFT JOIN table2task2 ON table1task2.id_klient=table2task2.id_klient GROUP BY table1task2.id_klient
