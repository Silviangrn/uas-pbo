package views;

import java.util.Scanner;

import usecases.MovieUsecase;

public class MovieView {

    public static void ShowMenuMovie() {
        Scanner inputScanner = new Scanner (System.in);

        // System.out.println("_____________________________");
        // System.out.println("List Movie");
        // System.out.println("_____________________________");

        // MovieUsecase movieUsecase = new MovieUsecase();
        // movieUsecase.GetMovieList(movid);

        System.out.println("---------------------------------");
        System.out.println("        =   MENU MOVIES   ="             );
        System.out.println("---------------------------------");
        System.out.println("|1| - List Movie");
        System.out.println("|2| - Add New Movie");
        System.out.println("|3| - Delete Movie");
        System.out.println("|0| - Back to Main Menu");
        System.out.println();
        System.out.println("Input Number Menu : ");
        Integer menu = inputScanner.nextInt();

        switch(menu) {
            case 1 :
                ShowListMovie();
                break;

            case 2: 
                ShowAddMovie();
                break;

            case 3: 
                ShowDeleteMovie();
                break;

            case 0 :
                LoginView.MainMenu();
                break;

        }
        ShowAddMovie();
        inputScanner.close();
    }

    public static void ShowListMovie() {
        System.out.println("-----------------------------");
        System.out.println("|         List Movie        |");
        System.out.println("-----------------------------");
        
        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.GetMovieList(1);
        ShowMenuMovie();
    }

    private static void ShowAddMovie() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("_____________________________");
        System.out.println("Movie Name :");
        String sMovieNam = inputScanner.nextLine();

        System.out.println("Genre :");
        String sGenre = inputScanner.nextLine();  

        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.AddMovie(sMovieNam, sGenre);

        ShowMenuMovie();
        inputScanner.close();
    }

    private static void ShowDeleteMovie() {
        Scanner inputScanner = new Scanner (System.in);

        System.out.println("_____________________________");
        System.out.println("Movie ID :");
        Integer iMovId = inputScanner.nextInt();

        MovieUsecase movieUsecase = new MovieUsecase();
        movieUsecase.DeleteMovie(iMovId);

        ShowMenuMovie();
        inputScanner.close();
    }

}
