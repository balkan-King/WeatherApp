package ch.noseryoung.plj;

public class StatisticsDisplay implements Displayable, MyPropertyChangeListener {

    private Double minTemperature;
    private Double maxTemperature;
    private Double averageTemperature;
    private Double minPressure;
    private Double maxPressure;
    private Double averagePressure;
    Integer minHumidity;
    Integer maxHumidity;
    Integer averageHumidity;
    int amount = 1;

    @Override
    public void display() {
        if(maxTemperature != null)
        System.out.println("Temperature today:\t\t\tPressure today:\t\t\t\tHumidity today:\n" +
                "------------------\t\t\t---------------\t\t\t\t---------------\n" +
                "minimum: " + minTemperature + " °C\t\t\tminimum: " + minPressure + " kPa\t\t\tminimum: " + minHumidity + "%\n" +
                "maximum: " + maxTemperature + " °C\t\t\tmaximum: " + maxPressure + " kPa\t\t\tmaximum: " + maxHumidity + "%\n" +
                "average: " + averageTemperature + " °C\t\t\taverage: " + averagePressure + " kPa\t\t\taverage " + averageHumidity + "%\n");
        else
            System.out.println("There are no values set yet");
    }

    @Override
    public void update() {
        changeTemperature();
        changePressure();
        changeHumidity();
        amount++;
    }

    private void changeTemperature(){
        Double newAverage = 0.0;
        Double currentTemp = CurrentData.getInstance().getCurrentTemperature();

        try {
            if (currentTemp > maxTemperature)
                maxTemperature = currentTemp;
            else if (currentTemp < minTemperature)
                minTemperature = currentTemp;

            for (int x = 1; x < amount; x++) {
                newAverage += averageTemperature;
            }
            newAverage += currentTemp;
            averageTemperature = newAverage / amount;
        }catch(NullPointerException e){
            minTemperature = currentTemp;
            maxTemperature = currentTemp;
            averageTemperature = currentTemp;
        }
    }

    private void changePressure(){
        Double newAverage = 0.0;
        Double currentPressure = CurrentData.getInstance().getCurrentPressure();

        try {
            if (currentPressure > maxPressure)
                maxPressure = currentPressure;
            else if (currentPressure < minPressure)
                minPressure = currentPressure;

            for (int x = 1; x < amount; x++) {
                newAverage += averagePressure;
            }
            newAverage += currentPressure;
            averagePressure = newAverage / amount;
        }catch(NullPointerException e){
            minPressure = currentPressure;
            maxPressure = currentPressure;
            averagePressure = currentPressure;
        }
    }

    private void changeHumidity(){
        int newAverage = 0;
        int currentHumidity = CurrentData.getInstance().getCurrentHumidity();

        try {
            if (currentHumidity > maxHumidity)
                maxHumidity = currentHumidity;
            else if (currentHumidity < minHumidity)
                minHumidity = currentHumidity;

            for (int x = 1; x < amount; x++) {
                newAverage += averageHumidity;
            }
            newAverage += currentHumidity;
            averageHumidity = newAverage / amount;
        }catch(NullPointerException e){
            minHumidity = currentHumidity;
            maxHumidity = currentHumidity;
            averageHumidity = currentHumidity;
        }
    }
}
