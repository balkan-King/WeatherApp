package test;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import ch.noseryoung.plj.StatisticsDisplay;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StatisticsDisplayTest {

    @Test
    public void updateAndGetters_registerCurrentData_expectCurrentData(){
        CurrentData currentData = CurrentData.getInstance();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        currentData.registerPropertyChangeListener(statisticsDisplay);

        currentData.measurementsChanged(20.0, 2000.0, 20);
        currentData.measurementsChanged(10.0, 1000.0, 10);

        assertEquals(10.0, statisticsDisplay.getMinTemperature());
        assertEquals(20.0, statisticsDisplay.getMaxTemperature());
        assertEquals(15.0, statisticsDisplay.getAverageTemperature());
        assertEquals(1000.0, statisticsDisplay.getMinPressure());
        assertEquals(2000.0, statisticsDisplay.getMaxPressure());
        assertEquals(1500.0, statisticsDisplay.getAveragePressure());
        assertEquals(10, statisticsDisplay.getMinHumidity());
        assertEquals(20, statisticsDisplay.getMaxHumidity());
        assertEquals(15, statisticsDisplay.getAverageHumidity());
    }

    @Test
    public void generateObject_expectStandardValue(){
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        assertNull(statisticsDisplay.getAverageHumidity());
        assertNull(statisticsDisplay.getAveragePressure());
        assertNull(statisticsDisplay.getAverageTemperature());
        assertNull(statisticsDisplay.getMaxHumidity());
        assertNull(statisticsDisplay.getMaxPressure());
        assertNull(statisticsDisplay.getMaxTemperature());
        assertNull(statisticsDisplay.getMinHumidity());
        assertNull(statisticsDisplay.getMinPressure());
        assertNull(statisticsDisplay.getMinTemperature());
        assertEquals(1, statisticsDisplay.getAmount());
    }

    @Test
    public void update_expectIncreasedAmountVaribale(){
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        statisticsDisplay.update();
        assertEquals(2, statisticsDisplay.getAmount());
    }

}
