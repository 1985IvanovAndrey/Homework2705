import com.sun.jmx.snmp.tasks.Task;
import task1.ConnectionToBD;
import task1.Task1;
import task2.Task2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    static Task1 task1 = new Task1();
    static Task2 task2 = new Task2();

    public static void main(String[] args) throws SQLException {

        //ConnectionToBD connectionToBD = new ConnectionToBD();
        //connectionToBD.myCreateConnection();
        //task1.fillingTabl1Task1FromScript();
        //task1.uniqueAdresFromTable1Task1();
        //task1.countAge();
        // task2.insertScriptsToTable1Task2();
        // task2.fillingTable1Task2FromScript();
        task2.insertScriptsToTable2Task2();
        task2.insertScriptsToTable1Task2();
    }
}