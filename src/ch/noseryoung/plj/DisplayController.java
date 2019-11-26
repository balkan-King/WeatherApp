package ch.noseryoung.plj;

public class DisplayController {

    private CurrentDisplay currentDisplay;
    private ForecastDisplay forecastDisplay;
    private StatisticsDisplay statisticsDisplay;
    private CurrentData currentData;

    public void DisplayController(){
        this.currentDisplay = new CurrentDisplay();
        this.forecastDisplay = new ForecastDisplay();
        this.statisticsDisplay = new StatisticsDisplay();
        this.currentData = CurrentData.getInstance();
    }

    public void showMenu(){
        System.out.println("Select which option you'd like to use\n" +
                "[1] to display the current data\n" +
                "[2] to display the forecast\n" +
                "[3] to display the statistics for today\n" +
                "[4] to change the data\n" +
                "[x] to leave the menu"
        );
    }

    public void switchCase(String entry){
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
    }

}
