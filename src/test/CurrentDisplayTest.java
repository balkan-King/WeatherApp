package test;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentDisplayTest {

    @Test
    public void update_registerCurrentData_expectCurrentData(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);

        currentData.measurementsChanged();

        assertNotNull(currentDisplay.getTemperature());
        assertNotNull(currentDisplay.getPressure());
        assertNotNull(currentDisplay.getHumidity());
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

        currentData.setCurrentHumidity(20.0);

        assertEquals(java.util.Optional.of(20.0), currentDisplay.getHumidity());
    }

    @Test
    public void generateObject_expectStandardValue(){
        CurrentDisplay currentDisplay = new CurrentDisplay();

        assertNull(currentDisplay.getTemperature());
        assertNull(currentDisplay.getPressure());
        assertNull(currentDisplay.getHumidity());
    }
}
