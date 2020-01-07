package ch.noseryoung.plj;

import javafx.beans.property.*;
import net.aksingh.owmjapis.*;
import org.json.JSONException;

public class WeatherModell {
    private final LongProperty cityID = new SimpleLongProperty(this, "cityID");
    private final StringProperty cityName = new SimpleStringProperty(this, "cityName");
    private final StringProperty temperature = new SimpleStringProperty(this, "temperature");
    private final StringProperty pressure = new SimpleStringProperty(this, "pressure");
    private final StringProperty humidity = new SimpleStringProperty(this, "humidity");
    private final StringProperty forecastTemperature = new SimpleStringProperty(this, "forecastTemperature");
    private final StringProperty forecastPressure = new SimpleStringProperty(this, "forecastPressure");
    private final StringProperty forecastHumidity = new SimpleStringProperty(this, "forecastHumidity");

    public void getWeather() throws JSONException {
        OpenWeatherMap wm =
                new OpenWeatherMap("a751ef3c1f5e5ae339aca36990024815"); // personal OWM API KEY
        CurrentWeather currentWeather = wm.currentWeatherByCityCode(cityID.longValue());
        DailyForecast fc = wm.dailyForecastByCityCode(cityID.longValue(), (byte) 1);

        this.cityName.set(currentWeather.getCityName());
        float tempC = (((currentWeather.getMainInstance().getTemperature()) - 32) * 5) / 9;
        this.temperature.set(String.format("%.1f", tempC));
        this.pressure.set(String.valueOf(currentWeather.getMainInstance().getPressure()));
        this.humidity.set(String.valueOf(currentWeather.getMainInstance().getHumidity()));

    }

    public WeatherModell(int cityID){
        this.cityID.set(cityID);
        getWeather();
    }

    @Override
    public String toString(){
        return "ID: "
                + cityID.get()
                + "\nCity Name: "
                + cityName.get()
                + "\nTemperature: "
                + temperature.get()
                + "\nPressure: "
                + pressure.get()
                + "\nHumidity: "
                + humidity.get()
                + "%\n";
    }

    public long getCityID() {
        return cityID.get();
    }

    public LongProperty cityIDProperty() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID.set(cityID);
    }

    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public String getTemperature() {
        return temperature.get();
    }

    public StringProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature.set(temperature);
    }

    public String getPressure() {
        return pressure.get();
    }

    public StringProperty pressureProperty() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure.set(pressure);
    }

    public String getHumidity() {
        return humidity.get();
    }

    public StringProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity.set(humidity);
    }
}
