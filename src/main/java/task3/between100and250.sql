-- 4) Выбрать записи по клиентам где платеж между 100 и 250.
SELECT id_client,date,(summa_salary*kurs) AS salary_in_the_currency_of_the_bank FROM table1task3 WHERE (summa_salary*table1task3.kurs)BETWEEN 100 AND 250