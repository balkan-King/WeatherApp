package ch.noseryoung.plj;

public class ForecastDisplay implements Displayable, MyPropertyChangeListener {

    private Double temperature = null;
    private Double pressure = null;
    private Double humidity = null;

    @Override
    public void display() {
        if(temperature != null)
            System.out.println("The forecasted temperature is: " + temperature + " °C\n" +
                    "The forecasted pressure is: " + pressure + " kPa\n" +
                    "The forecasted humidity is: " + humidity + "%\n");
        else{
            System.out.println("There are no values set yet");
        }
    }

    @Override
    public void update() {
        temperature = (double) Math.round((CurrentData.getInstance().getCurrentTemperature() + (Math.random() * 4 - 2)) *10) / 10;
        pressure = (double) Math.round((CurrentData.getInstance().getCurrentPressure() + (Math.random() * 4 - 2)) * 10) / 10;
        humidity = (double) Math.round((CurrentData.getInstance().getCurrentHumidity() + (Math.random() * 4 - 2)) * 10) / 10;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }


}
