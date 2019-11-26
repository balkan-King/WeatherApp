package ch.noseryoung.plj;

public class CurrentData {
    private static Double currentTemperature;
    private static Double currentPressure;
    private static int currentHunmidity;
    private static CurrentData instance;


    //constructor
    private CurrentData() {
    }
    //Singleton
    public static CurrentData getInstance(){
        if (CurrentData.instance == null) {
            CurrentData.instance = new CurrentData ();
        }
        return CurrentData.instance;
    }


    //class functions
    public void registerObserver(){

    }

    public void removeObserver(){

    }

    public void notifyObserver(){

    }

    public void changeForm(){

    }

    public void measurementsChanged(Double currentTemperature, Double currentPressure, int currentHumidity){
        this.currentTemperature = currentTemperature;
        this.currentPressure = currentPressure;
        this.currentHunmidity = currentHumidity;
    }


    //Getter and Setters
    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getCurrentPressure() {
        return currentPressure;
    }

    public int getCurrentHunmidity() {
        return currentHunmidity;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setCurrentPressure(Double currentPressure) {
        this.currentPressure = currentPressure;
    }

    public void setCurrentHunmidity(int currentHunmidity) {
        this.currentHunmidity = currentHunmidity;
    }
}
