package task2;

import task1.ConnectionToBD;
import task1.Person;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task2 {

    private ArrayList<Person> person2 = new ArrayList<>();
    ConnectionToBD connectionToBD = new ConnectionToBD();
    public final String INSERT_SCRIPT_FILE1 = "C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\insertToTable1Task2.sql";
    public final String INSERT_SCRIPT_FILE2 = "C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\insertToTable2Task2.sql";
    private final String INSERT_SCRIPT1 = "INSERT INTO table1task2(id_klient,FIO) VALUES (";
    private final String INSERT_SCRIPT2 = "INSERT INTO table2task2(id_klient,data,summa_salary) VALUES (";


    public void insertScriptsToTable1Task2() throws SQLException {
        System.out.println("Добавление записей в скрипт insertScriptsToTable1Task2");
        person2.add(new Person(1, "Bila", "Robin"));
        person2.add(new Person(2, "Bili", "Robins"));
        person2.add(new Person(3, "Bilik", "Robinson"));
        person2.add(new Person(4, "Bilu", "Robinson"));
        person2.add(new Person(5, "Bilsa", "Robinson"));
        person2.add(new Person(6, "Bilma", "Robinson"));
        person2.add(new Person(7, "Bilka", "Robinson"));
        person2.add(new Person(8, "Bilol", "Robinson"));
        person2.add(new Person(9, "Bilos", "Robinson"));
        person2.add(new Person(10, "Bilp", "Robinson"));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INSERT_SCRIPT_FILE1, false))) {
            for (Person person : person2) {
                bw.write(INSERT_SCRIPT1 + "'" + person.getId() + "', '" + person.getName() + " " + person.getSerName() + "');");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
        fillingTable1Task2FromScript();
    }

    public void fillingTable1Task2FromScript() throws SQLException {
        connectionToBD.myCreateConnection();
        ArrayList<String> tableField = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INSERT_SCRIPT_FILE1))) {
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
        System.out.println("Запсиь данных в таблицу Table1Task2 из скрипта выполнена!");
        System.out.println("----------------------------------------------------------");
    }

    public void insertScriptsToTable2Task2() throws SQLException {
        System.out.println("Добавление записей в скрипт insertScriptsToTable2Task2");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INSERT_SCRIPT_FILE2, false))) {
            bw.write(INSERT_SCRIPT2 + "'" + 1 + "', '" + "2017.05.03" + "', '" + 700 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 15 + "', '" + "2019.05.03" + "', '" + 900 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 7 + "', '" + "2012.05.03" + "', '" + 1500 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 7 + "', '" + "2011.05.03" + "', '" + 2500 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 9 + "', '" + "2013.05.03" + "', '" + 3500 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 1 + "', '" + "2016.05.03" + "', '" + 4500 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 6 + "', '" + "2001.05.03" + "', '" + 5600 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 5 + "', '" + "2008.05.03" + "', '" + 5700 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 9 + "', '" + "2021.05.03" + "', '" + 5900 + "');");
            bw.newLine();
            bw.write(INSERT_SCRIPT2 + "'" + 3 + "', '" + "2023.05.03" + "', '" + 1500 + "');");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
        fillingTable2Task2FromScript();
    }

    public void fillingTable2Task2FromScript() throws SQLException {
        connectionToBD.myCreateConnection();
        ArrayList<String> tableField = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(INSERT_SCRIPT_FILE2))) {
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
        System.out.println("Запсиь данных в таблицу Table2Task2 из скрипта выполнена!");
        System.out.println("----------------------------------------------------------");
    }

    public void summaSalaryFromIdTable1() throws SQLException {
        connectionToBD.myCreateConnection();
        String script = "SELECT table1task2.id_klient,SUM(table2task2.summa_salary) FROM table1task2 LEFT JOIN table2task2 ON table1task2.id_klient=table2task2.id_klient GROUP BY table1task2.id_klient";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод дохода по id из первой таблицы:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\summaSalaryFromIdTable1.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }


    public void printMaxDate() throws SQLException {
        connectionToBD.myCreateConnection();
        String script = "SELECT table1task2.id_klient,max(table2task2.data) FROM table1task2 JOIN table2task2 ON table1task2.id_klient=table2task2.id_klient GROUP BY table1task2.id_klient";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод последней даты получения дохода:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\maxDate.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }
    public void printIdNotTable1Task2() throws SQLException {
        connectionToBD.myCreateConnection();
        String script = "select table2task2.id_klient,SUM(summa_salary) from table2task2 where table2task2.id_klient not in (select id_klient from table1task2) GROUP BY table2task2.id_klient,table2task2.summa_salary;";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод id, которых нет в первой таблице, но по ним есть доходы:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\printIdNotTable1Task2.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }
    public void printIdNotTable2Task2() throws SQLException {
        connectionToBD.myCreateConnection();
        String script = "SELECT * FROM table1task2 WHERE id_klient not IN (SELECT id_klient FROM table2task2)";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Показать клиентов которые есть в первой таблице а во второй их нет:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task2\\printIdNotTable2Task2.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }
}

