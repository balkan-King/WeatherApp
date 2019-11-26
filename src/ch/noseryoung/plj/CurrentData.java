package ch.noseryoung.plj;

public class CurrentData {
    Double currentTemperature;
    Double currentPressure;
    int currentHunmidity;


    //constructor
    public CurrentData(Double currentTemperature, Double currentPressure, int currentHumidity) {
        this.currentTemperature = currentTemperature;
        this.currentPressure = currentPressure;
        this.currentHunmidity = currentHumidity;
    }


    //class functions
    public void registerObserver(){

    }

    public void removeObserver(){

    }

    public void notifyObserver(){

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
