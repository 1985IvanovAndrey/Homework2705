import com.sun.jmx.snmp.tasks.Task;
import task1.ConnectionToBD;
import task1.Task1;
import task2.Task2;
import task3.Task3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    static Task1 task1 = new Task1();
    static Task2 task2 = new Task2();
    static Task3 task3 = new Task3();

    public static void main(String[] args) throws SQLException {

        // task1.insertScriptsToTable1Task1();//сохранения скрипта в sql файл и запись в БД,table1task1
        //task1.uniqueAdresFromTable1Task1();//вывод уникальных адресов
        //task1.countAge();//Вывод количества людей каждого возраста:

        //task2.insertScriptsToTable1Task2();//сохранения скрипта в sql файл и запись в БД,table1task2
        //task2.insertScriptsToTable2Task2();//сохранения скрипта в sql файл и запись в БД,table2task2
        //task2.summaSalaryFromIdTable1();//сумма дохода по id из первой таблицы
        //task2.printMaxDate();//вывод мах даты дохода по id из первой таблицы
        //task2.printIdNotTable1Task2();//Показать клиентов которых нет в первой таблице,  но по ним есть доходы
        //task2.printIdNotTable2Task2();//Показать клиентов которые есть в первой таблице а во второй их нет.

        task3.insertScriptsToTable1Task3();//сохранения скрипта в sql файл и запись в БД,table1task3
        task3.salaryInTheCurrencyOfTheBbank();//) Показать сумму дохода по клиенту в валюте банка

    }
}