package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Tom", "Tomas", (byte) 25);
        userService.saveUser("John", "Johnson", (byte) 45);
        userService.saveUser("Charly", "Chaplin", (byte) 28);
        userService.saveUser("Ben", "Stiller", (byte) 55);

        userService.getAllUsers().forEach(System.out :: println);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
