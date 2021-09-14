package za.co.commandquality.AssetManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.commandquality.AssetManagement.models.User;
import za.co.commandquality.AssetManagement.services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;


@RestController
@RequestMapping( "/api" )
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @PostMapping("/")
    public int create(@RequestBody User user ) {
        int insertResult = 0;

            insertResult = userService.create(user.getUserId(),user );
            if (insertResult >= 0)
                new LogHelper().loggerFunc(
                        "target/success_report.log",
                        Level.INFO );
            else
            new LogHelper().loggerFunc(
                    "target/failure_report.log",
                    Level.WARNING,
                    new SQLException(   "\nAttempt to update" + user + " failed. \n"));

        return insertResult;
    }

    @GetMapping
    public List < User > read() {
        List < User > userList = userService.read().stream().toList();
        if (!(userList.isEmpty())) {
            new LogHelper().loggerFunc(
                    "target/success_report.log",
                    Level.FINER );

        } else {
            new LogHelper().loggerFunc(
                    "target/failure_report.log",
                    Level.WARNING,
                    new SQLException( "\nAttempt to get all user list has failed: " + userList + " failed. \n" ) );

        }
        return userList;
    }

    @GetMapping("/descending")
    public List < User >  DisplayTableInDescendingOrder() {
        List < User > userList = userService.readDescending().stream().toList();
        if (!(userList.isEmpty())) {
            new LogHelper().loggerFunc(
                    "target/success_report.log",
                    Level.FINER );

        } else {
            new LogHelper().loggerFunc(
                    "target/failure_report.log",
                    Level.WARNING,
                    new SQLException( "\nAttempt to get all user list has failed: " + userList + " failed. \n" ) );

        }
        return userList;
    }

    @GetMapping("/ascending")
    public List < User > DisplayTableInAscendingOrder() {
        List < User > userList = userService.readAscending().stream().toList();
        if (!(userList.isEmpty())) {
            new LogHelper().loggerFunc(
                    "target/success_report.log",
                    Level.FINER );

        } else {
            new LogHelper().loggerFunc(
                    "target/failure_report.log",
                    Level.WARNING,
                    new SQLException( "\nAttempt to get all user list has failed: " + userList + " failed. \n" ) );

        }
        return userList;
    }
    @PutMapping("/{id}" )
    public void update( @PathVariable UUID id, @RequestBody User user ) {
        userService.update( id, user );
    }

    @GetMapping("/{id}" )
    public Optional < User > readById( @PathVariable( "id" ) UUID id ) {
        return userService.readById( id );
    }

    @DeleteMapping("/{id}" )
    public void deleteById( @PathVariable( "id" ) UUID id ) {
        userService.deleteById( id );
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }
}
