package za.co.commandquality.AssetManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import za.co.commandquality.AssetManagement.dao.UserDao;
import za.co.commandquality.AssetManagement.models.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public record UserService(UserDao userDao) {

    @Autowired
    public UserService( @Qualifier( "postgres" ) UserDao userDao ) {
        this.userDao = userDao;
    }

    public int create( UUID id, User user ) {
        return userDao.create( id, user );
    }

    public List < User > read() {
        return userDao.read();
    }

    public List < User > readAscending() {
        return userDao.readAscending();
    }

    public List < User > readDescending() {
        return userDao.readDescending();
    }

    public int update( UUID id, User user ) {
        return userDao.update( id, user );
    }

    public Optional < User > readById( UUID id ) {
        return userDao.readById( id );
    }

    public int deleteById( UUID id ) {
        return userDao.deleteById( id );
    }

    public void deleteAll() {
        userDao.deleteAll();
    }
}
