package usermanagementapp.service.impls;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import usermanagementapp.data.models.User;
import usermanagementapp.data.repositories.UserRepository;
import usermanagementapp.service.UserService;
import usermanagementapp.service.dtos.InputUserDto;
import usermanagementapp.service.dtos.ReadUserDto;
import usermanagementapp.service.dtos.ReadUserNamesAndEmailDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedData(List<String> inputList) {
        if (this.userRepository.count() == 0) {

            for (String string : inputList) {
                String[] tokens = string.split("\\s+");

                String firstName = tokens[0];
                String lastName = tokens[1];
                LocalDate birthDate = null;
                if (!tokens[2].equalsIgnoreCase("null")) {
                    birthDate = LocalDate.parse(tokens[2]);
                }
                String phoneNumber = tokens[3];
                String email = tokens[4];

                InputUserDto userDto = new InputUserDto(firstName, lastName, birthDate, phoneNumber, email);
                User user = modelMapper.map(userDto, User.class);

                this.userRepository.saveAndFlush(user);
            }
        }
    }

    @Override
    public ReadUserNamesAndEmailDto findUserByEmail(String email) {
        User userByLastNameLike = this.userRepository.findUserByEmailLike(email);
        return this.modelMapper.map(userByLastNameLike, ReadUserNamesAndEmailDto.class);
    }

    @Override
    public List<ReadUserDto> findAllUsers() {
        return this.userRepository.findAllUsersOrderByFirstNameAndDateOfBirth().stream()
                .map(u -> modelMapper.map(u, ReadUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReadUserDto> findUsersByBirthDateAfter(LocalDate date) {
        return this.userRepository.findAllByDateOfBirthAfter(date).stream()
                .map(u -> modelMapper.map(u, ReadUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public int updateUserByEmail(String email) {
        return this.userRepository.updateUserByEmailLike(email);
    }

    @Override
    public void deleteUsersWhereDateOfBirthIsNull() {
        this.userRepository.deleteUsersWhereDateOfBirthIsNull();
    }
}
