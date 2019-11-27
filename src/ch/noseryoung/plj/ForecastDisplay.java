package ch.noseryoung.plj;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastDisplay implements Displayable, PropertyChangeListener {

    @Override
    public void display() {
        System.out.println("Display 2");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
