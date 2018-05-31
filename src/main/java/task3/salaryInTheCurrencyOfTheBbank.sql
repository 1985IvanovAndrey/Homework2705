SELECT id_client, Sum(summa_salary*kurs) AS salary_in_the_currency_of_the_bank FROM table1task3 GROUP BY id_client
