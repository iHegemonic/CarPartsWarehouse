package designpatterns.observer;

public class Customer implements Observer {

    private String name;
    private String orderedPart;


    public Customer(String name, String orderedPart) {
        this.name = name;
        this.orderedPart = orderedPart;
    }

    public String getOrderedPart() {
        return orderedPart;
    }

    @Override
    public void update(String message) {
        System.out.println("Notify " + name + ": " + message);
        System.out.println("---------------------------------------------------------");
    }
}
