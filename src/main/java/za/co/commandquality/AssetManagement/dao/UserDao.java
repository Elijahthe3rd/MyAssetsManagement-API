package za.co.commandquality.AssetManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import za.co.commandquality.AssetManagement.models.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Repository( "postgres" )
public class UserDao implements Dao < User > {

    private final JdbcTemplate jdbcTemplate;

    RowMapper < User > rowMapper = ( resultSet, index ) -> {
        UUID id = UUID.fromString( resultSet.getString( "id" ) );
        String name = resultSet.getString( "name" );
        String lastname = resultSet.getString( "lastname" );
        return new User( id, name, lastname );
    };


    @Autowired
    public UserDao( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create( UUID id, User user ) {
        String sql = "INSERT INTO user_table(id,name,lastname) values(?,?,?)";
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
    public void update( UUID id, User user ) {
        String sql = "UPDATE user_table SET";
        System.out.println( "What do you wish to update?\n1:name\2lastName:\n3:name & lastName" );
        int userInput = new Scanner( System.in ).nextInt();
        int update;
        switch (userInput) {
            case 1:
                sql+="name=? where id=?";
                update= jdbcTemplate.update( sql, user.getName());
                break;
            case 2:
                sql+="lastname=? where id=?";

                update= jdbcTemplate.update( sql, user.getName());
                break;
            case 3:
                sql+="name = ? lastname=? where id=?";
            update= jdbcTemplate.update( sql, user.getName(), user.getLastname(), id );

        }

    }

    @Override
    public Optional < User > readById( UUID id ) {
        String sql = "select * from user_table where id=?";

//      works but, I prefer the option after the one below
//      User user =jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper );

        User user = read().get( id.version() );
        return Optional.ofNullable( user );
    }

    @Override
    public void deleteById( UUID id ) {
        String sql = "DELETE FROM user_table WHERE id=?";
        int deleteValue = jdbcTemplate.update( sql, id );
        if (deleteValue >= 0) {
            System.out.println( deleteValue );
        }
    }

    @Override
    public void deleteAll() {
        if (!(read().isEmpty())) {
            String sql = "DELETE * user_table";
            jdbcTemplate.update( sql );
        }
    }
}




