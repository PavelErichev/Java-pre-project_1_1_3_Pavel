package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

  /*      try (Connection connection = Util.getConnection();
             Statement creatTable = connection.createStatement();
        ) {
            String sql = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER, " +
                    "CONSTRAINT PRIMARY KEY(id))";
            creatTable.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void dropUsersTable() {

  /*      try (Connection connection = Util.getConnection();
             Statement dropTable = connection.createStatement();
        ) {
            String sql = "DROP TABLE IF EXISTS Users";
            dropTable.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void saveUser(String name, String lastName, byte age) {
        /*try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Users(name,lastName,age) VALUES (?, ?, ?) ");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    public void removeUserById(long id) {
        /*try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    public List<User> getAllUsers() {
       /* List<User> people = new ArrayList<>();
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                people.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(people);
        return people;*/
        return null;
    }

    public void cleanUsersTable() {
        /*try {
            Connection connection = Util.getConnection();
            Statement cleanTable = connection.createStatement();
            String sql = "Truncate table Users";
            cleanTable.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}