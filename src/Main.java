import designpatterns.observer.Customer;
import designpatterns.singleton.Warehouse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = Warehouse.getInstance();
        designpatterns.observer.OrderWarehouse orderWarehouse = new designpatterns.observer.OrderWarehouse();

        Customer relu = new Customer("Relu", "Oil Filter");
        Customer gelu = new Customer("Gelu", "Catalytic Converter");


        orderWarehouse.addOrder(relu, "Oil Filter");
        orderWarehouse.addOrder(gelu, "Catalytic Converter");

        warehouse.addCarPart("Oil Filter");
        orderWarehouse.notifyObservers();

        warehouse.addCarPart("Catalytic Converter");
        orderWarehouse.notifyObservers();


    }
}