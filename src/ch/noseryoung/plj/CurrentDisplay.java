package ch.noseryoung.plj;

public class CurrentDisplay implements Displayable, MyPropertyChangeListener {

    private Double temperature;
    private Double pressure;
    private int humidity;

    public CurrentDisplay(){
        temperature = 0.0;
        pressure = 0.0;
    }

    @Override
    public void display() {
        System.out.println("The current temperature is: " + temperature + " °C\n" +
                "The current pressure is: " + pressure + " kPa\n" +
                "The current humidity is: " + humidity + "%\n");
    }

    @Override
    public void update() {
        temperature = CurrentData.getInstance().getCurrentTemperature();
        pressure = CurrentData.getInstance().getCurrentPressure();
        humidity = CurrentData.getInstance().getCurrentHumidity();
    }
}
