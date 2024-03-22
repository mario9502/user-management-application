The application is build with Spring Boot using JDK 21 and Local MySQL Database

To start the app simply just run the "UserManagementApplication" class

All the methods that executes the functionalities are located in the CommandLineRunnerImpl class

ModelMapper was used to convert the DTO's to POJO and vice versa.

===================================================================

**FUNCTIONALITY EXPLANATION**

seedData() - creates users and inserts them in the database by reading the information from a txt file located in "resources" folder

getUserByEmail() - returns ReadUserNamesAndEmailDto with a certain given email

getAllUsers() - returns all users from the database with sorting by Last Name and Date of Birth

getUsersWithBirthDateAfter() - returns list users with search included where the search term is found

updateUser() - updates user with a certain given email

deleteUsersWhereDateOfBirthIsNull() - deletes all users from the database which don't have date of birth
