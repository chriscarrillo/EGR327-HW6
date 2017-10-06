import org.apache.commons.io.*;
import org.apache.commons.lang3.*;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Dealer implements Serializable {
    private static final long serialVersionUID = 2079013919829783322L;
    private Inventory inventory;

    /**
     * Default constructor sets the inventory
     */
    public Dealer() {
        inventory = new Inventory();
    }

    /**
     * Loads inventory data from a text file on the web
     * @param filePath the web URL
     * @throws IOException if url or scanner cannot be opened
     */
    public void loadData(String filePath) throws IOException {
        URL url = new URL(filePath);
        Scanner data = new Scanner(url.openStream());

        while (data.hasNextLine()) {
            String line = data.nextLine();
            String[] fields = line.split(",");
            inventory.add(new Vehicle(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), line.endsWith(",")));
        }
    }

    /**
     * Serializes the dealer object
     */
    public void serializeDealer() {
        File file = FileUtils.getFile("dealer.ser");
        byte[] data = SerializationUtils.serialize(inventory);
        try {
            FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes the dealer object
     */
    public void deserializeDealer() {
        File file = FileUtils.getFile("dealer.ser");

        byte[] dataToDeserialize = null;
        try {
            dataToDeserialize = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Inventory deserializedDealer = SerializationUtils.deserialize(dataToDeserialize);
        for (Vehicle v : deserializedDealer.getInventoryList()) {
            v.printVehicleMM();
            System.out.println();
        }
    }

    /**
     *
     * @param inv the inventory
     */
    public void generateReport(Inventory inv) {
        File report = FileUtils.getFile("report.txt");

        for (Vehicle v : inv.getInventoryList()) {
            try {
                FileUtils.write(report, v.toString(), "ISO-8859-1", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
