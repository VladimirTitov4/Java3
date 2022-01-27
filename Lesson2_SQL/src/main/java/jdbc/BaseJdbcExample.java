package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseJdbcExample {

    public static final String DB_URL = "jdbc:sqlite:C:/IdeaProjects/Java3/java3.db";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

//            int modifiedRows = statement.executeUpdate("delete from students where name = 'Екатерина' and score = 4;");
//            System.out.println("modifiedRows = " + modifiedRows);

//            statement.executeUpdate("insert into students (name, group_name, score) VALUES ('Екатерина', 'group3', 4)");
//            statement.executeUpdate("insert into students (name, group_name, score) VALUES ('Екатерина', 'group3', 4)");

            List<Student> studentsByScore = getStudentsByScore(4, statement);
//            for (Student student : studentsByScore) {
//                System.out.println(student);
//            }

            System.out.println("----------------");

            List<Student> studentsByUserName = getStudentsByUserName("DELETE * FROM users", statement);
//            for (Student student : studentsByUserName) {
//                System.out.println(student);
//            }

            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where name = ?");
            System.out.println(">>>>>>>>>>>>>>>>>");
            List<Student> studentsByUserNamePrepared = getStudentsByUserNamePrepared("Владимир", preparedStatement);
//            for (Student student : studentsByUserNamePrepared) {
//                System.out.println(student);
//            }

            // Transactional testing
            connection.createStatement().executeUpdate("delete from students where group_name = 'TestGroup'");
            long start = System.currentTimeMillis();
            transactionalTest(connection);
            System.out.println("Время выполнение " + (System.currentTimeMillis() - start));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> getStudentsByUserNamePrepared(String userName, PreparedStatement statement) throws SQLException {
        List<Student> studentsByScore = new ArrayList<>();

        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString("name");
            String group_name = resultSet.getString("group_name");
            int score = resultSet.getInt(4);

            studentsByScore.add(new Student(id, name, group_name, score));
        }

        return studentsByScore;
    }

    private static List<Student> getStudentsByScore(int scoreAvg, Statement statement) throws SQLException {
        List<Student> studentsByScore = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery("select * from students where score = " + scoreAvg);
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString("name");
            String group_name = resultSet.getString("group_name");
            int score = resultSet.getInt(4);

            studentsByScore.add(new Student(id, name, group_name, score));
        }

        return studentsByScore;
    }

    private static List<Student> getStudentsByUserName(String userName, Statement statement) throws SQLException {
        List<Student> studentsByScore = new ArrayList<>();

        String sql = String.format("select * from students where name = '%s'", userName);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString("name");
            String group_name = resultSet.getString("group_name");
            int score = resultSet.getInt(4);

            studentsByScore.add(new Student(id, name, group_name, score));
        }

        return studentsByScore;
    }

    private static void transactionalTest(Connection connection) throws SQLException {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students (name, group_name, score) VALUES (?, ?, ?)")) {
            connection.setAutoCommit(true); // true - Индивидуальная транзакция, долгое время выполнения. connection.commit() нужно выключить
            for (int i = 1; i <= 1000; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setString(2, "TestGroup");
                prepInsert.setInt(3, i * 10 % 100);
                prepInsert.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        connection.commit();
    }
}
