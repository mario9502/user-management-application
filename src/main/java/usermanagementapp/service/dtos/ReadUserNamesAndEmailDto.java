package usermanagementapp.service.dtos;

import java.io.Serializable;

public class ReadUserNamesAndEmailDto implements Serializable {

    private String firstName;
    private String lastName;
    private String email;

    public ReadUserNamesAndEmailDto() {}

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
                            + "Email: %s" + System.lineSeparator(), getFirstName(), getLastName(), getEmail());
    }
}
