package com.kainos.ea.project;
import com.kainos.ea.project.useractions.HR;
import com.kainos.ea.project.useractions.UserAction;

import java.util.Scanner;


public class Main {
    private static User user;
    private static UserAction userAction;
    public static Scanner sc = new Scanner(System.in);
    public static DBConnection db = new DBConnection();

    public static void main(String[] args){
        while(true){
            // Login
            if(user == null){
                user = Login.login(sc);
                switch (user.userType){
                    case HR: userAction = new HR(); break;
                }
            } else {
                // Menu
                userAction.getOptions();
                System.out.println("q. Exit application");
                String option = sc.nextLine();
                if (option.equals("q")){
                    user = null;
                } else {
                    userAction.handleOption(option);
                }
            }
        }
    }
}
