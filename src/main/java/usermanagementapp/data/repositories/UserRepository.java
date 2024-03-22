package usermanagementapp.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usermanagementapp.data.models.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailLike(String email);

    @Query(value = "FROM User ORDER BY lastName, dateOfBirth")
    List<User> findAllUsersOrderByFirstNameAndDateOfBirth();

    List<User> findAllByDateOfBirthAfter(LocalDate date);

    @Transactional
    @Modifying
    @Query(value = "UPDATE User SET firstName = 'Updated' WHERE email LIKE :email")
    int updateUserByEmailLike(String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM User WHERE dateOfBirth IS NULL")
    void deleteUsersWhereDateOfBirthIsNull();
}
