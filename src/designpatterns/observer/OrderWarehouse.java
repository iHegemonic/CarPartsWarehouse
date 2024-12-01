package designpatterns.observer;

import designpatterns.singleton.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderWarehouse implements Subject {

    private List<Observer> customers;
    private Map<Observer, String> orders;

    public OrderWarehouse() {
        customers = new ArrayList<>();
        orders = new HashMap<>();
    }

    @Override
    public void addOrder(Observer observer, String part) {
        customers.add(observer);
        orders.put(observer, part);
        System.out.println("---------------------------------------------------------");
        System.out.println("Order placed: " + ((Customer) observer).getOrderedPart());

    }

    @Override
    public void removeOrder(Observer observer) {
        customers.remove(observer);
        orders.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<Observer> fulfilledOrders = new ArrayList<>();

        for (Observer customer : customers) {
            String part = orders.get(customer);
            if (Warehouse.getInstance().isPartAvailable(part)) {
                Warehouse.getInstance().completeOrder(part);
                customer.update("Your order is ready: " + part);
                fulfilledOrders.add(customer);
            }
        }


        for (Observer customer : fulfilledOrders) {
            removeOrder(customer);
        }
    }


}
