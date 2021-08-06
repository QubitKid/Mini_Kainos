package com.kainos.ea.project;

import java.util.Scanner;

public class Login {
    public static User login(Scanner sc){
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        // Validation (username + password)
        if(password.equals("test")){
            return new User(UserType.HR);
        } else {
            System.out.println("Invalid credentials. Please try again");
            return null;
        }
    }
}
