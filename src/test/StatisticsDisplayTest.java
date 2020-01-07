package test;

import ch.noseryoung.plj.CurrentData;
import ch.noseryoung.plj.CurrentDisplay;
import ch.noseryoung.plj.StatisticsDisplay;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsDisplayTest {

    @Test
    public void updateAndGetters_registerCurrentData_expectCurrentData(){
        CurrentData currentData = CurrentData.getInstance();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        currentData.registerPropertyChangeListener(statisticsDisplay);

        currentData.measurementsChanged();
        currentData.measurementsChanged();

        assertNotNull(statisticsDisplay.getMinTemperature());
        assertNotNull(statisticsDisplay.getMaxTemperature());
        assertNotNull(statisticsDisplay.getAverageTemperature());
        assertNotNull(statisticsDisplay.getMinPressure());
        assertNotNull(statisticsDisplay.getMaxPressure());
        assertNotNull(statisticsDisplay.getAveragePressure());
        assertNotNull(statisticsDisplay.getMinHumidity());
        assertNotNull(statisticsDisplay.getMaxHumidity());
        assertNotNull(statisticsDisplay.getAverageHumidity());
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
