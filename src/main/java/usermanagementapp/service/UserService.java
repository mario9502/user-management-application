package usermanagementapp.service;

import usermanagementapp.service.dtos.ReadUserDto;
import usermanagementapp.service.dtos.ReadUserNamesAndEmailDto;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    void seedData(List<String> inputList);

    ReadUserNamesAndEmailDto findUserByEmail(String email);

    List<ReadUserDto> findAllUsers();

    List<ReadUserDto> findUsersByBirthDateAfter(LocalDate date);

    int updateUserByEmail(String email);

    void deleteUsersWhereDateOfBirthIsNull();
}
