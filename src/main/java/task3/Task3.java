package task3;

import task1.ConnectionToBD;
import task1.Person;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task3 {
    public final String INSERT_SCRIPT_FILE = "C:\\Java\\project\\Homework2705\\src\\main\\java\\task3\\insertToTable1Task3.sql";
    private final String INSERT_SCRIPT = "INSERT INTO table1task3(id_client,date,summa_salary,kurs) VALUES (";
    private ArrayList<Person> person3 = new ArrayList<>();
    ConnectionToBD connectionToBD = new ConnectionToBD();

    public void insertScriptsToTable1Task3() throws SQLException {
        System.out.println("Добавление записей в скрипт insertScriptsToTable1Task3");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INSERT_SCRIPT_FILE, false))) {
            bw.write(INSERT_SCRIPT + "'" + 1 + "', '" + "2013.04.01" + "', '" + 100 + "', '" + 1 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 1 + "', '" + "2013.04.02" + "', '" + 150 + "', '" + 2 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 2 + "', '" + "2013.04.01" + "', '" + 200 + "', '" + 1 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 3 + "', '" + "2013.04.01" + "', '" + 250 + "', '" + 3 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 3 + "', '" + "2013.04.02" + "', '" + 300 + "', '" + 1 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 3 + "', '" + "2013.04.03" + "', '" + 350 + "', '" + 2 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT + "'" + 7 + "', '" + "2013.05.08" + "', '" + 600 + "', '" + 1 + "');");
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
        fillingTable1Task3FromScript();
    }

    public void fillingTable1Task3FromScript() throws SQLException {
        connectionToBD.myCreateConnection();
        ArrayList<String> tableField = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INSERT_SCRIPT_FILE))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                tableField.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : tableField) {
            Statement statement = connectionToBD.getConnection().createStatement();
            statement.execute(s);
        }
        System.out.println("Запсиь данных в таблицу Table1Task3 из скрипта выполнена!");
        System.out.println("----------------------------------------------------------");
    }
    public void salaryInTheCurrencyOfTheBbank() throws SQLException {
        connectionToBD.myCreateConnection();
        String script = "SELECT id_client, Sum(summa_salary*kurs) AS salary_in_the_currency_of_the_bank FROM table1task3 GROUP BY id_client";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод суммы дохода по клиенту в валюте банка:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task3\\salaryInTheCurrencyOfTheBbank.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }
}


