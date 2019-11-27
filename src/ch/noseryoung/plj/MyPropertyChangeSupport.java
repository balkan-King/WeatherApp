package ch.noseryoung.plj;

import java.util.ArrayList;

public class MyPropertyChangeSupport {

    private ArrayList<MyPropertyChangeListener> propertyChangeListeners = new ArrayList<>();

    public void addPropertyChangeListener(MyPropertyChangeListener property){
        propertyChangeListeners.add(property);
    }

    public void removePropertyChangeListener(MyPropertyChangeListener property){
        for(MyPropertyChangeListener myPropertyChangeListener : propertyChangeListeners){
            if(property == myPropertyChangeListener)
                propertyChangeListeners.remove(myPropertyChangeListener);
        }
    }

    public void firePropertyChange(){
        for(MyPropertyChangeListener myPropertyChangeListener : propertyChangeListeners){
            myPropertyChangeListener.update();
        }
    }
}
