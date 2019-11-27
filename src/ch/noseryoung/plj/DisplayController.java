package ch.noseryoung.plj;

import java.util.Scanner;

public class DisplayController {

    private CurrentDisplay currentDisplay = new CurrentDisplay();
    private ForecastDisplay forecastDisplay = new ForecastDisplay();
    private StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
    private CurrentData currentData = CurrentData.getInstance();

    public DisplayController(){
        currentData.registerPropertyChangeListener(currentDisplay);
        currentData.registerPropertyChangeListener(forecastDisplay);
        currentData.registerPropertyChangeListener(statisticsDisplay);
    }

    public void showMenu(){
        System.out.println("\n".repeat(10));
        System.out.println("Select which option you'd like to use\n" +
                "[1] to display the current data\n" +
                "[2] to display the forecast\n" +
                "[3] to display the statistics for today\n" +
                "[4] to change the data\n" +
                "[x] to leave the menu"
        );
    }

    public void switchCase(String entry){
        Scanner inputValue = new Scanner(System.in);

        switch(entry.toLowerCase()){
            case "1":
                currentDisplay.display();
                break;
            case "2":
                forecastDisplay.display();
                break;
            case "3":
                statisticsDisplay.display();
                break;
            case "4":
                currentData.changeForm();
                break;
            default:
                System.out.println("Please enter a valid value");
                break;
            case "x":
                break;
        }
        System.out.println("Enter to continue");
        inputValue.nextLine();
    }

    public CurrentDisplay getCurrentDisplay() {
        return currentDisplay;
    }

    public ForecastDisplay getForecastDisplay() {
        return forecastDisplay;
    }

    public StatisticsDisplay getStatisticsDisplay() {
        return statisticsDisplay;
    }

    public CurrentData getCurrentData() {
        return currentData;
    }
}
