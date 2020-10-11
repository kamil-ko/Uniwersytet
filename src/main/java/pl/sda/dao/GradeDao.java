package pl.sda.dao;

import java.sql.*;

public class GradeDao {

    private final Connection connection;


    public GradeDao(Connection connection) {
        this.connection = connection;
    }

    public void add(String firstName,String lastName,String subject,int grade) {
        String insertSql = "INSERT INTO UNIVERSITY.GRADE (FIRST_TERM,STUDENT_ID,SUBJECT_ID) VALUES (?,select STUDENT_ID from UNIVERSITY.STUDENT where FIRST_NAME = ? and LAST_NAME = ?,SELECT SUBJECT_ID FROM UNIVERSITY.GRADE WHERE NAME = ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,grade);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, subject);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Dodano ocenę z id: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Nie mozna utworzyc oceny dla studenta");
        }
    }



}
