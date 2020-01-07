package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import org.junit.Test;

public class CurrentDataTest{

    @Test
    public void registerAndRemovePropertyChangeListener_requestCurrentDisplayObject_expectSizeOneAndZero(){
        CurrentData currentData = CurrentData.getInstance();
        CurrentDisplay currentDisplay = new CurrentDisplay();
        currentData.registerPropertyChangeListener(currentDisplay);
        //check
        assertEquals(1, currentData.getSupport().size());
        currentData.removePropertyChangeListener(currentDisplay);
        //check
        assertEquals(0, currentData.getSupport().size());
    }

    @Test
    public void measurementsChanged_requestDummyData_expectDummyData(){
        CurrentData currentData = CurrentData.getInstance();
        currentData.measurementsChanged();
        assertNotNull(currentData.getCurrentTemperature());
        assertNotNull(currentData.getCurrentPressure());
        assertNotNull(currentData.getCurrentHumidity());
    }

    @Test
    public void setAndGetTemperature_request25_expect25(){
        CurrentData currentData = CurrentData.getInstance();
        currentData.setCurrentTemperature(25.0);
        assertEquals(25.0, currentData.getCurrentTemperature());
    }

    @Test
    public void setAndGetPressure_request2500_expect2500(){
        CurrentData currentData = CurrentData.getInstance();
        currentData.setCurrentPressure(2500.0);
        assertEquals(2500.0, currentData.getCurrentPressure());
    }

    @Test
    public void setAndGetHumidity_request25_expect25(){
        CurrentData currentData = CurrentData.getInstance();
        currentData.setCurrentHumidity(25.0);
        assertEquals(25.0, currentData.getCurrentHumidity());
    }
}
