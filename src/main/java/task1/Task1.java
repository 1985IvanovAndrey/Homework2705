package task1;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public final String INSERT_SCRIPT_FILE = "C:\\Java\\project\\Homework2705\\src\\main\\java\\task1\\insertToTable1Task1.sql";
    private ArrayList<Person> persons = new ArrayList<>();
    private final String INSERT_SCRIPT = "INSERT INTO table1task1(FIO, adres, phone, age) VALUES (";
    ConnectionToBD connectionToBD = new ConnectionToBD();

    public void insertScriptsToTable1Task1() throws SQLException {
        System.out.println("Добавление записей в скрипт insertScriptsToTable1Task1");
        persons.add(new Person("Bil", "Robinson", "kosiora 15", "+380501254789", 8));
        persons.add(new Person("John", "Carlos", "kosiora 20", "+380501254779", 10));
        persons.add(new Person("Vin", "Owen", "kosiora 25", "+380501654789", 15));
        persons.add(new Person("Bob", "Messi", "kosiora 30", "+380501254749", 9));
        persons.add(new Person("Bil", "Ronaldo", "kosiora 45", "+380501224889", 44));
        persons.add(new Person("Kiwi", "Wardy", "kosiora 20", "+380501255559", 55));
        persons.add(new Person("Steave", "Newman", "kosiora 17", "+380501123789", 66));
        persons.add(new Person("Coul", "Conte", "kosiora 19", "+380501254999", 77));
        persons.add(new Person("Mike", "Velom", "kosiora 18", "+380501254888", 43));
        persons.add(new Person("Varan", "Contex", "kosiora 55", "+380501254777", 66));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INSERT_SCRIPT_FILE, false))) {
            for (Person person : persons) {
                bw.write(INSERT_SCRIPT + "'" + person.getName() + " " + person.getSerName() + "', '" + person.getAdres() + "', '" + person.getPhone() + "', '" + person.getAge() + "');");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
        fillingTable1Task1FromScript();
    }

    public void fillingTable1Task1FromScript() throws SQLException {
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
        System.out.println("Запсиь данных в таблицу Table1Task1 из скрипта выполнена!");
        System.out.println("----------------------------------------------------------");
    }

    public void uniqueAdresFromTable1Task1() throws SQLException {
        connectionToBD.myCreateConnection();
        String script="SELECT adres FROM table1task1 GROUP BY adres HAVING COUNT(*)=1";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод уникальных адресов из Table1Task1:");
        while (rs2.next()) {
            System.out.println("Адрес=" + rs2.getString(1));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task1\\uniqueAdresFromTable1Task1.sql", false))) {
                bw.write(script);
                bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }

    public void countAge() throws SQLException {
        connectionToBD.myCreateConnection();
        String script="Select age, count(*) from table1task1 group by age";
        PreparedStatement pr = connectionToBD.getConnection().prepareStatement(script);
        ResultSet rs2 = pr.executeQuery();
        System.out.println("Вывод количества людей каждого возраста:");
        while (rs2.next()) {
            System.out.println(rs2.getString(1) + "=" + rs2.getString(2));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Java\\project\\Homework2705\\src\\main\\java\\task1\\countAge.sql", false))) {
            bw.write(script);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------");
    }
}