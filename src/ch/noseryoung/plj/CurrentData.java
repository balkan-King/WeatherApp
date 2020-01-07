package ch.noseryoung.plj;

public class CurrentData {
    private Double currentTemperature;
    private static Double currentPressure;
    private static Double currentHumidity;
    private static CurrentData instance;
    private MyPropertyChangeSupport support = new MyPropertyChangeSupport(); //Observer
    private WeatherModell wm = new WeatherModell(2657896);


    //constructor
    private CurrentData() {
        currentTemperature = 0.0;
        currentPressure = 0.0;
        currentHumidity = 0.0;
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

    public void measurementsChanged(){
        this.currentTemperature = Double.parseDouble(wm.getTemperature());
        this.currentPressure = Double.parseDouble(wm.getPressure());
        this.currentHumidity = Double.parseDouble(wm.getHumidity());
        support.firePropertyChange();
    }

    public void measurementsChanged(Double temperature, Double pressure, Double humidity){
        this.currentTemperature = temperature;
        this.currentPressure = pressure;
        this.currentHumidity = humidity;
        support.firePropertyChange();
    }

    //Getter and Setters
    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getCurrentPressure() {
        return currentPressure;
    }

    public Double getCurrentHumidity() {
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

    public void setCurrentHumidity(Double currentHunmidity) {
        this.currentHumidity = currentHunmidity;
        support.firePropertyChange();
    }


}
