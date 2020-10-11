package pl.sda;

import pl.sda.database.DatabaseManager;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try {
            DatabaseManager databaseManager = new DatabaseManager();

            databaseManager.createDatabaseIfNotPresent("STUDENT");


            String createEmployeeTable1Sql = "CREATE TABLE UNIVERSITY.STUDENT " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " FIRST_NAME VARCHAR(255), " +
                    " LAST_NAME VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            databaseManager.createTableIfNotPresent("UNIVERSITY.STUDENT", createEmployeeTable1Sql);

            String createEmployeeTable2Sql = "CREATE TABLE UNIVERSITY.SUBJECT " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            databaseManager.createTableIfNotPresent("UNIVERSITY.SUBJECT", createEmployeeTable2Sql);

            String createEmployeeTable3Sql = "CREATE TABLE UNIVERSITY.GRADE " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " FIRST_TERM INTEGER, " +
                    " SECOND_TERM INTEGER, " +
                    " STUDENT_ID INTEGER, " +
                    " SUBJECT_ID INTEGER, " +
                    " FOREIGN KEY (STUDENT_ID) REFERENCES UNIVERSITY.Student(id), " +
                    " FOREIGN KEY (SUBJECT_ID) REFERENCES UNIVERSITY.Subject(id), " +
                    " PRIMARY KEY ( id ))";
            databaseManager.createTableIfNotPresent("UNIVERSITY.GRADE", createEmployeeTable3Sql);



            databaseManager.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
