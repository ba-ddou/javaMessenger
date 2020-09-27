package Observer;

import java.util.ArrayList;

import dp.Message;

public abstract class Observable {
    protected ArrayList<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    public void dispatch(Message msg) {
        for (Observer obs : observers) {
            obs.onUpdate(msg);
        }
    }

}