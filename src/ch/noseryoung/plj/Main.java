package ch.noseryoung.plj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    String entry = "";
        Scanner inputValue = new Scanner(System.in);
        DisplayController displayController = new DisplayController();


        displayController.getCurrentData().measurementsChanged(10.0, 2000.0, 25.0);

        do{
            displayController.showMenu();
            entry = inputValue.nextLine();
            displayController.switchCase(entry);
        }while(!("x").equals(entry.toLowerCase()));

    }
}
