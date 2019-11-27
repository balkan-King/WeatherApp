package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import org.junit.Test;

public class CurrentDisplayTest {

    @Test
    public void update_registerCurrentData_expectCurrentData(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);

        currentData.measurementsChanged(20.0, 2000.0, 20);

        assertEquals(20.0, currentDisplay.getTemperature());
        assertEquals(2000.0, currentDisplay.getPressure());
        assertEquals(20, currentDisplay.getHumidity());
    }

    @Test
    public void setCurrentTemperature_register20_expect20(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);

        currentData.setCurrentTemperature(20.0);

        assertEquals(20.0, currentDisplay.getTemperature());
    }

    @Test
    public void setCurrentPressure_register2000_expect2000(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);

        currentData.setCurrentPressure(2000.0);

        assertEquals(2000.0, currentDisplay.getPressure());
    }

    @Test
    public void setCurrentHumidity_register20_expect20(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);

        currentData.setCurrentHumidity(20);

        assertEquals(20, currentDisplay.getHumidity());
    }

    @Test
    public void generateObject_expectStandardValue(){
        CurrentDisplay currentDisplay = new CurrentDisplay();

        assertEquals(0.0, currentDisplay.getTemperature());
        assertEquals(0.0, currentDisplay.getPressure());
        assertEquals(0, currentDisplay.getHumidity());
    }
}
