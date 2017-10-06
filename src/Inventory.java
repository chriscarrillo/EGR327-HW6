import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends ArrayList implements Serializable {
    private static final long serialVersionUID = -2761813925380376883L;
    private List<Vehicle> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public List<Vehicle> getInventoryList() { return inventory; }

    public void add(Vehicle v) {
        inventory.add(v);
    }

    public void remove(Vehicle v) {
        inventory.remove(v);
    }

    public int getSize() {
        return inventory.size();
    }

    public Vehicle get(int index) {
        return inventory.get(index);
    }

    public Vehicle findCheapestVehicle() {
        if (inventory.isEmpty()) {
            return null;
        }

        Vehicle cheapest = inventory.get(0);

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getRetailPrice() < cheapest.getRetailPrice())
                cheapest = inventory.get(i);
        }

        return cheapest;
    }

    public Vehicle findMostExpensiveVehicle() {
        if (inventory.isEmpty()) {
            return null;
        }

        Vehicle expensive = inventory.get(0);

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getRetailPrice() > expensive.getRetailPrice())
                expensive = inventory.get(i);
        }

        return expensive;
    }

    public void printAveragePriceOfAllVehicles() {
        int sum = 0;

        for (int i = 0; i < inventory.size(); i++) {
            sum += inventory.get(i).getRetailPrice();
        }

        System.out.println(sum / inventory.size());
    }
}
