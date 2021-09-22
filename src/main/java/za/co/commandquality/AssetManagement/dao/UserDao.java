package za.co.commandquality.AssetManagement.dao;

import java.util.UUID;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import za.co.commandquality.AssetManagement.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.commandquality.AssetManagement.models.user.Gender;
import za.co.commandquality.AssetManagement.models.user.Address;
import za.co.commandquality.AssetManagement.models.user.Contacts;

@Repository( "postgres" )
public class UserDao implements Dao < User > {

    private final JdbcTemplate jdbcTemplate;

    RowMapper < User > rowMapper = ( resultSet, index ) -> {
        UUID id = UUID.fromString( resultSet.getString( "id" ) );
        String name = resultSet.getString( "name" );
        String lastname = resultSet.getString( "lastname" );
        Gender gender = ( Gender ) resultSet.getObject( "gender" );
        Address address = ( Address ) resultSet.getObject( "address" );
        Contacts contacts = ( Contacts ) resultSet.getObject( "contacts" );
        return new User( id, name, lastname ,gender,address,contacts);
    };


    @Autowired
    public UserDao( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create( UUID id, User user ) {
        String sql = "INSERT INTO user_table(id,name,lastname,gender) values(?,?,?,?)";
        int rowInsert = jdbcTemplate.update( sql, user.getUserId(), user.getName(), user.getLastname() );
        return (rowInsert >= 0) ? rowInsert : -1;
    }

    @Override
    public List < User > read() {
        String sql = "select * from user_table";
        return jdbcTemplate.query( sql, rowMapper );
    }
    @Override
    public List < User > readAscending() {
        String sql = "select * from user_table order by name asc";
        return jdbcTemplate.query( sql, rowMapper );
    }

    @Override
    public List < User > readDescending() {
        String sql = "select * from user_table order by name desc";
        return jdbcTemplate.query( sql, rowMapper );
    }
    @Override
    public int update( UUID id, User user ) {
        String sql = "UPDATE user_table SET";
        System.out.println( "What do you wish to update?\n1:name\2lastName:\n3:gender \n4:name & lastName" );
        int userInput = new Scanner( System.in ).nextInt();
        int update;
        switch (userInput) {
            case 1 -> {
                sql += "name=? where id=?";
                update = jdbcTemplate.update( sql, user.getName() );
            }
            case 2 -> {
                sql += "lastname=? where id=?";
                update = jdbcTemplate.update( sql, user.getName() );
            }
            case 3 -> {
                sql += "gender=? where id=?";
                update = jdbcTemplate.update( sql, user.getGender() );
            }
            case 4 -> {
                sql += "name = ? lastname=? where id=?";
                update = jdbcTemplate.update( sql, user.getName(), user.getLastname(), id );
            }
            default -> throw new IllegalStateException( "Unexpected value: " + userInput );
        }
        return update;

    }

    @Override
    public Optional < User > readById( UUID id ) {
//        String sql = "select * from user_table where id=?";

//      works but, I prefer the option after the one below
//      User user =jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper );

        User user = read().get( id.version() );
        return Optional.ofNullable( user );
    }

    @Override
    public int deleteById( UUID id ) {
        String sql = "DELETE FROM user_table WHERE id=?";
        return  jdbcTemplate.update( sql, id );
    }

    @Override
    public void deleteAll() {
        if (!(read().isEmpty())) {
            String sql = "DELETE * user_table";
            jdbcTemplate.update( sql );
        }
    }
}