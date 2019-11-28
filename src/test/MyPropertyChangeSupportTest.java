package test;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPropertyChangeSupportTest {

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

}
