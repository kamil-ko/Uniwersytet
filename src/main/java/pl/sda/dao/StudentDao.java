package pl.sda.dao;

import pl.sda.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDao {

    private final Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }



    public void add(String firstName, String lastName) {
        String insertSql = "INSERT INTO UNIVERSITY.STUDENT (FIRST_NAME,  LAST_NAME) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Dodano studenta z id: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Nie mozna utworzyc studenta");
        }
    }



     public List<Student> getAllStudent() {
        String selectSql = "SELECT * FROM UNIVERSITY.STUDENT";
        try (ResultSet resultSet = this.connection.createStatement().executeQuery(selectSql)) {
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                students.add(new Student(id, firstName, lastName));
            }
            return students;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
