package views;

import java.util.Scanner;

import usecases.RentUsecase;

public class RentView {

    public static void ShowRentMenu () {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("      =   MENU Rental   ="        );
        System.out.println("---------------------------------");
        System.out.println("|1| - List Rent");
        System.out.println("|2| - Add New Rent");
        System.out.println("|3| - Return Rent");
        System.out.println("|0| - Back to Main Menu");
        System.out.println();
        System.out.println("Input Number Menu : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1 :
                ShowListRent();
                break;

            case 2: 
                ShowAddRent();
                break;

            case 3: 
                ShowReturnRent();
                break;

            case 0 :
                LoginView.MainMenu();
                break;

        }
        ShowAddRent();
        inputScanner.close();
    }

    public static void ShowListRent() {
        System.out.println("-----------------------------");
        System.out.println("|          List Rent         |");
        System.out.println("-----------------------------");
        
        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.GetRentList(1);
        ShowRentMenu();
    }

    private static void ShowAddRent() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("_____________________________");
        System.out.println("Rent Date :");
        String sRentDate = inputScanner.nextLine();

        System.out.println("Movie ID :");
        Integer sMovId = inputScanner.nextInt();

        System.out.println("Renter :");
        String sRenter = inputScanner.nextLine();  

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.NewRent(sRentDate, sMovId, sRenter);

        ShowRentMenu();
        inputScanner.close();
    }

    private static void ShowReturnRent() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("_____________________________");
        System.out.println("  Rent ID :");
        Integer iRent = inputScanner.nextInt();
        inputScanner.nextLine(); // Membersihkan karakter newline yang tersisa di buffer

        System.out.println("  Rent Date :");
        String sReturnRent = inputScanner.nextLine();

        RentUsecase rentUsecase = new RentUsecase();
        rentUsecase.SetReturnRent(iRent, sReturnRent);

        ShowRentMenu();
        inputScanner.close();
    }

}
