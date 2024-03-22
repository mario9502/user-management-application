package usermanagementapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import usermanagementapp.service.UserService;
import usermanagementapp.service.dtos.ReadUserNamesAndEmailDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    public static final String FILE_PATH = "src/main/resources/users.txt";

    private final UserService userService;

    public CommandLineRunnerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData(); //imports users to the database from the "users" file located in resources folder

        String email = "mario@mail.com";
        LocalDate date = LocalDate.of(1990, 1, 1);

        //getUserByEmail(email);                       // Reading one user
        //getAllUsers();                               // Reading all the users with sorting by Last Name and Date of Birth
        //getUsersWithBirthDateAfter(date);            // Reading all the users with search included
        //updateUser(email);                           // updateUser
        //deleteUsersWhereDateOfBirthIsNull();         // deleteUser
    }

    private void deleteUsersWhereDateOfBirthIsNull() {
        getAllUsers();
        this.userService.deleteUsersWhereDateOfBirthIsNull();
        getAllUsers();
    }

    private void updateUser(String email) {
        getUserByEmail(email);
        int updatedCount = this.userService.updateUserByEmail(email);
        System.out.println("Users updated: " + updatedCount);
        getUserByEmail(email);
    }

    private void getUsersWithBirthDateAfter(LocalDate date) {
        this.userService.findUsersByBirthDateAfter(date)
                .forEach(System.out::println);
    }

    private void getAllUsers() {
        this.userService.findAllUsers().forEach(System.out::println);
    }

    private void getUserByEmail(String email) {
        ReadUserNamesAndEmailDto userByEmail = this.userService.findUserByEmail(email);

        System.out.println(userByEmail);
    }

    private void seedData() throws IOException {
        List<String> inputList = Files.readAllLines(Path.of(FILE_PATH));
        this.userService.seedData(inputList);
    }
}
