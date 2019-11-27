package test;

import ch.noseryoung.plj.DisplayController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayControllerTest {

    @Test
    public void constructor_requestInstance_expectStandardValue(){
        DisplayController displayController = new DisplayController();

        assertEquals(3, displayController.getCurrentData().getSupport().size());
        assertNotNull(displayController.getCurrentDisplay());
        assertNotNull(displayController.getForecastDisplay());
        assertNotNull(displayController.getStatisticsDisplay());
    }

}
