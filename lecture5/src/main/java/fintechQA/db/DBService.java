package fintechQA.db;

import fintechQA.db.dao.AddressDAO;
import fintechQA.db.dao.PersonDAO;
import fintechQA.model.Address;
import fintechQA.model.Person;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBService {

    private final Connection connection;

    public DBService() {
        this.connection = getMysqlConnection();
    }

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("my_db_name?").         //db name
                    append("useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&").     //other parameters
                    append("user=root&").          //login
                    append("password=0005000");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person getPerson(String surname, String name, String middleName) throws DBException {
        try {
            return (new PersonDAO(connection).get(surname, name, middleName));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long deletePerson(long id) throws DBException {
        try {
            return (new PersonDAO(connection).deletePerson(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long addPerson(Person Person) throws DBException {
        try {
            long id;
            connection.setAutoCommit(false);
            AddressDAO addressDAO = new AddressDAO(connection);
            PersonDAO personDAO = new PersonDAO(connection);
            addressDAO.createTable();
            personDAO.createTable();
            id = personDAO.insertPerson(Person);
            connection.commit();
            return id;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public List<Person> getRandListPersons(int rowNum) throws DBException {
        try {
            return (new PersonDAO(connection).getRandLimit(rowNum));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

}
