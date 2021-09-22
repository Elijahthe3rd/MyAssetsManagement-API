package za.co.commandquality.AssetManagement.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao<T>{

    default int create(T t){
        UUID id=UUID.randomUUID();
        return create( id,t );
    }

    int create(UUID id,T t);
    List <T> read();//select * from the db_tableName
    List <T> readAscending();//select from the tableName display data sorted in ascending manner / order
    List <T> readDescending();//select from the tableName display data sorted descending manner / order

    int update(UUID id,T t); // "update table_name SET NAME = ? LASTNAME = ? where user_id = ?"
    Optional<T> readById( UUID id); //"select * from table_name where id=?"

    int deleteById( UUID id );//"delete from table where id=?"
    void deleteAll(); //"drop table table_Name"


}
