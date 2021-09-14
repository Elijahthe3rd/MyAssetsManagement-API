package za.co.commandquality.AssetManagement.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import za.co.commandquality.AssetManagement.dao.UserDao;
import za.co.commandquality.AssetManagement.services.UserService;


@ExtendWith( MockitoExtension.class )
public class UserControllerTest {
    @Mock
    UserDao userDao;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {

    }

    @Test
    void read() {
    }

    @Test
    void displayTableInDescendingOrder() {
    }

    @Test
    void displayTableInAscendingOrder() {
    }

    @Test
    void update() {
    }

    @Test
    void readById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }
}