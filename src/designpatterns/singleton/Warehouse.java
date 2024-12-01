package designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static Warehouse instance;
    private List<String> availableParts;

    private Warehouse() {
        availableParts = new ArrayList<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void addCarPart(String part) {
        availableParts.add(part);
        System.out.println("---------------------------------------------------------");
        System.out.println(part + "has been added to inventory");
        System.out.println("---------------------------------------------------------");
    }

    public boolean isPartAvailable(String part) {
        return availableParts.contains(part);
    }

    public void completeOrder(String part) {
        if (availableParts.contains(part)) {
            availableParts.remove(part);
        }
    }
}
