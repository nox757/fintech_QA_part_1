package fintechQA.db.dao;

import fintechQA.db.executor.Executor;
import fintechQA.model.Address;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class AddressDAO {

    private Executor executor;

    public AddressDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists address (" +
                "id int auto_increment not null," +
                "postcode varchar(256)," +
                "country varchar(256)," +
                "region varchar(256)," +
                "city varchar(256)," +
                "street varchar(256)," +
                "house int," +
                "flat int," +
                "primary key (id) )"
        );
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("DROP TABLE address");
    }

    public long insertAddress(Address address) throws SQLException {
        return executor.execUpdate(String.format("insert into address " +
                        "(postcode, country, region, city, street, house, flat) " +
                        "values ('%s', '%s', '%s', '%s', '%s', %d, %d)",
                address.getPostCode(),
                address.getCountry(),
                address.getRegion(),
                address.getCity(),
                address.getStreet(),
                address.getNumHouse(),
                address.getNumFlat()
        ));
    }

    public long deleteAddress(long id) throws SQLException {
        return executor.execUpdate("delete from Persons where id=" + id);
    }
}
