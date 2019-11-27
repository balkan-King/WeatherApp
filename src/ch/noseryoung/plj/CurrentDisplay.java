package ch.noseryoung.plj;

public class CurrentDisplay implements Displayable, MyPropertyChangeListener {

    private Double temperature;
    private Double pressure;
    private Integer humidity;


    @Override
    public void display() {
        if(temperature != null)
        System.out.println("The current temperature is: " + temperature + " °C\n" +
                "The current pressure is: " + pressure + " kPa\n" +
                "The current humidity is: " + humidity + "%\n");
        else{
            System.out.println("There are no values set yet");
        }
    }

    @Override
    public void update() {
        temperature = CurrentData.getInstance().getCurrentTemperature();
        pressure = CurrentData.getInstance().getCurrentPressure();
        humidity = CurrentData.getInstance().getCurrentHumidity();
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
