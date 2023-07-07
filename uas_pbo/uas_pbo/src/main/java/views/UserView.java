package views;

import java.util.Scanner;

import usecases.UserUsecase;

public class UserView {
    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("_____________________________");
        System.out.println(          "List User");

        UserUsecase UserUsecase = new UserUsecase();
        UserUsecase.getUserList();
        
        System.out.println("---------------------------------");
        System.out.println(          ":: MENU ::");
        System.out.println("---------------------------------");
        System.out.println("|1| - Add New User Account");
        System.out.println("|2| - Change Password");
        System.out.println("|0| - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Number Menu : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1 :
                ShowAddUser();
                break;

            case 2: 
                ShowChangePass();
                break;

            case 0 :
                WelcomeView.ShowWelcomeview();
                break;

        }

        inputScanner.close();
    }
    
    private static void ShowAddUser() {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("============================");
        System.out.println("Userid : ");
        String sUserid = inputScanner.nextLine();
        System.out.println("Password : ");
        String sPass = inputScanner.nextLine();

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.addUser(sUserid, sPass);

        ShowUserMain();

        inputScanner.close();
    }

    private static void ShowChangePass() {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("============================");
        System.out.println("Userid : ");
        String sUserid = inputScanner.nextLine();
        System.out.println("Password : ");
        String sPass = inputScanner.nextLine();

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.changePassUser(sUserid, sPass);

        ShowUserMain();

        inputScanner.close();
    }

}
