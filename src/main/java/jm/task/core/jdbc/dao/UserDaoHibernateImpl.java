package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS people " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY , " +
                    "name VARCHAR(50) NOT NULL, " +
                    "lastName VARCHAR(50) NOT NULL, " +
                    "age TINYINT NOT NULL)";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS people";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            } else {
                throw new IllegalArgumentException("User не найден");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        List<User> list = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            list = session.createQuery("FROM User").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            String stringQuery = "DELETE FROM User";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}