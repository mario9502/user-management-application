package usermanagementapp.service.dtos;

import java.time.LocalDate;

public class ReadUserDto {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

    public ReadUserDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("First name: %s" + System.lineSeparator()
                + "Last name: %s" + System.lineSeparator()
                + "Date of birth: %s" + System.lineSeparator()
                + "Phone number: %s" + System.lineSeparator()
                + "Email: %s" + System.lineSeparator(), getFirstName(), getLastName(), getDateOfBirth(), getPhoneNumber(), getEmail());
    }
}
