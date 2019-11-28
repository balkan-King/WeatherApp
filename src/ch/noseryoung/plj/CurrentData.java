package ch.noseryoung.plj;

import java.util.Scanner;

public class CurrentData {
    private static Double currentTemperature;
    private static Double currentPressure;
    private static Integer currentHumidity;
    private static CurrentData instance;
    private MyPropertyChangeSupport support = new MyPropertyChangeSupport(); //Observer


    //constructor
    private CurrentData() {
        currentTemperature = 0.0;
        currentPressure = 0.0;
        currentHumidity = 0;
    }
    //Singleton
    public static CurrentData getInstance(){
        if (CurrentData.instance == null) {
            CurrentData.instance = new CurrentData ();
        }
        return CurrentData.instance;
    }


    //class functions
    public void registerPropertyChangeListener(MyPropertyChangeListener p){
        support.addPropertyChangeListener(p);
    }

    public void removePropertyChangeListener(MyPropertyChangeListener p){
        support.removePropertyChangeListener(p);
    }

    //functions to change the values
    public void changeForm(){
        Double temperature;
        Double pressure;
        int humidity;
        Scanner inputValue = new Scanner(System.in);

        System.out.println("Enter the current temperature in Celsius in the following format xx.xx");
        temperature = inputValue.nextDouble();
        System.out.flush();
        System.out.println("Enter the current pressure in the following format xxxx.xx");
        pressure = inputValue.nextDouble();
        System.out.flush();
        System.out.println("Enter the current humidity in Celsius in the following format xx");
        humidity = inputValue.nextInt();
        System.out.flush();

        measurementsChanged(temperature, pressure, humidity);
    }

    public void measurementsChanged(Double currentTemperature, Double currentPressure, int currentHumidity){
        this.currentTemperature = currentTemperature;
        this.currentPressure = currentPressure;
        this.currentHumidity = currentHumidity;
        support.firePropertyChange();
    }


    //Getter and Setters
    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getCurrentPressure() {
        return currentPressure;
    }

    public int getCurrentHumidity() {
        return currentHumidity;
    }

    public MyPropertyChangeSupport getSupport() {
        return support;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
        support.firePropertyChange();
    }

    public void setCurrentPressure(Double currentPressure) {
        this.currentPressure = currentPressure;
        support.firePropertyChange();
    }

    public void setCurrentHumidity(int currentHunmidity) {
        this.currentHumidity = currentHunmidity;
        support.firePropertyChange();
    }


}
