package fintechQA.db.dao;

import fintechQA.db.executor.Executor;
import fintechQA.model.Address;
import fintechQA.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private Executor executor;

    private AddressDAO addressDAO;

    private final static String BASE_SQL_QUERY = "select p.surname, p.name, p.middlename, " +
            "p.birthday, p.gender, p.inn, " +
            "a.postcode, a.country, a.region, " +
            "a.city, a.street, a.house, a.flat " +
            "from Persons p, Address a " +
            "where p.address_id=a.id ";

    public PersonDAO(Connection connection) {
        this.executor = new Executor(connection);
        addressDAO = new AddressDAO(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists persons (" +
                "id int auto_increment not null," +
                "surname varchar(256)," +
                "name varchar(256)," +
                "middlename varchar(256)," +
                "birthday date," +
                "gender varchar(1)," +
                "inn varchar(12)," +
                "address_id int not null," +
                "foreign key (address_id) references address(id)," +
                "primary key (id) )"
        );
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table person");
    }

    public Person get(String surname, String name, String middleName) throws SQLException {
        return executor.execQuery(BASE_SQL_QUERY +
                " and p.surname='" + surname +
                "' and p.name='" + name +
                "' and p.middlename='" + middleName + "'", result -> {
            if (result.next()) {
                Person person = new Person();
                oneParseFromBaseSqlQuery(result, person);
                return person;
            } else {
                return null;
            }
        });
    }

    public long insertPerson(Person person) throws SQLException {
        long addressId = addressDAO.insertAddress(person.getAddress());
        return executor.execUpdate(String.format("insert into Persons " +
                        "(surname, name, middlename, birthday, gender, inn, address_id)" +
                        "values ('%s', '%s', '%s', '%s', '%s', '%s', %d)",
                person.getSurname(),
                person.getName(),
                person.getMiddleName(),
                Date.valueOf(person.getBirthday()).toString(),
                person.getGender(),
                person.getInn(),
                addressId
        ));
    }

    public long deletePerson(long id) throws SQLException {
        return executor.execUpdate("delete from Persons where id=" + id);
    }

    public List<Person> getRandLimit(int numRow) throws SQLException {
        return executor.execQuery(String.format(BASE_SQL_QUERY +
                " order by rand() limit %d", numRow), PersonDAO::handle);
    }

    private static List<Person> handle(ResultSet result) throws SQLException {
        List<Person> listStudent = new ArrayList<>();
        while (result.next()) {
            Person person = new Person();
            oneParseFromBaseSqlQuery(result, person);
            listStudent.add(person);
        }
        return listStudent;
    }

    private static void oneParseFromBaseSqlQuery(ResultSet result, Person person) throws SQLException {
        Address address = new Address();
        person.setSurname(result.getString(1))
                .setName(result.getString(2))
                .setMiddleName(result.getString(3))
                .setBirthday(result.getDate(4).toLocalDate())
                .setGender(result.getString(5))
                .setInn(result.getString(6));
        address.setPostCode(result.getString(7))
                .setCountry(result.getString(8))
                .setRegion(result.getString(9))
                .setCity(result.getString(10))
                .setStreet(result.getString(11))
                .setNumHouse(result.getInt(12))
                .setNumFlat(result.getInt(13));
        person.setAddress(address);
    }

}
