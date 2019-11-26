package ch.noseryoung.plj;

public class CurrentDisplay implements Displayable {

    @Override
    public void display() {
        System.out.println("The current temperature is: " + CurrentData.currentTemperature + "\n" +
                "The current pressure is: " + CurrentData.currentPressure + "\n" +
                "The current humidity is: " + CurrentData.currentHunmidity + "\n");
    }

}
