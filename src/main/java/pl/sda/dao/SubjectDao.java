package pl.sda.dao;

import pl.sda.model.Student;
import pl.sda.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubjectDao {
    private final Connection connection;

    public SubjectDao(Connection connection) {
        this.connection = connection;
    }


    public void add(String name) {
        String insertSql = "INSERT INTO UNIVERSITY.SUBJECT (NAME) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Dodano przedmiot z id: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Nie mozna utworzyc przedmiotu");
        }
    }


    public List<Subject> getAllSubject() {
        String selectSql = "SELECT * FROM UNIVERSITY.SUBJECT";
        try (ResultSet resultSet = this.connection.createStatement().executeQuery(selectSql)) {
            List<Subject> subjects = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                subjects.add(new Subject(id,name));
            }
            return subjects;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
