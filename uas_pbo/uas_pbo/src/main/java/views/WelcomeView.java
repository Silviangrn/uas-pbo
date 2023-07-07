package views;

import java.util.Scanner;

public class WelcomeView {
    public static void main(String[] args) {
        ShowWelcomeview();
    }

    public static void ShowWelcomeview() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println();
        System.out.println(".:: Welcome to Movie Rent Apps ::.");
        System.out.println("____________________________________");
        System.out.println();
        System.out.println("|1| - Login Page");
        System.out.println("|2| - Create Account");
        System.out.println("|0| - Exit");
        System.out.println();
        System.out.println("Input Number Menu : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1 :
                LoginView.ShowLoginPage();
                break;

            case 2: 
                UserView.ShowUserMain();
                break;

            case 0 :
                System.out.println("Application Closed !!");
                break;

        }

        inputScanner.close();
        
    }
    
}
