package views;

import java.util.Scanner;

import usecases.LoginUsecase;

public class LoginView {
    public static void ShowLoginPage() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("       :: Login page ::");
        System.out.println("---------------------------------");

        System.out.println("User Id :");
        String userid = inputScanner.nextLine();

        System.out.println("Password :");
        String pass = inputScanner.nextLine();

        LoginUsecase loginUsecase = new LoginUsecase();
        String sValidate = loginUsecase.LoginValidate(userid, pass);

        if (sValidate.equals("")) {
            System.out.println("Login - Success");
            System.out.println();
            MainMenu();

        } else {
            System.out.println();
            System.out.println("Login - Failed - " + sValidate);
            System.out.println();
        }
        inputScanner.close();

    }

    public static void MainMenu() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("---------------------------------");
        System.out.println("            :: MENU ::           ");
        System.out.println("---------------------------------");
        System.out.println("|1| - Movie  ");
        System.out.println("|2| - Rent ");
        System.out.println("|0| - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Number Menu : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1 :
                MovieView.ShowMenuMovie();
                break;
            
            case 2 :
                RentView.ShowRentMenu();
                break;

            case 0 :
                WelcomeView.ShowWelcomeview();
                break;

        }

        inputScanner.close();
    }


}
