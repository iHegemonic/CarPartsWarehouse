package designpatterns.observer;

public interface Subject {

    void addOrder(Observer observer, String part);
    void removeOrder(Observer observer);
    void notifyObservers();
}
