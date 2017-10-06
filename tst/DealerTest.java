import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DealerTest {
    private Dealer dealer = new Dealer();
    private Inventory inv = new Inventory();

    private void fillInventory() {
        inv.add(new Vehicle("Ford F150", 2015, 30000, true));
        inv.add(new Vehicle("Ford Focus", 2010, 15000, false));
        inv.add(new Vehicle("Ford Fiesta", 2012, 18000, false));
        inv.add(new Vehicle("Ford Fusion", 2015, 20000, false));
        inv.add(new Vehicle("Ford Mustang", 1999, 8000, false));
        inv.add(new Vehicle("Ford GT", 2017, 30000, false));
        inv.add(new Vehicle("Ford Taurus", 2015, 25000, false));
        inv.add(new Vehicle("GM Sierra", 2016, 40000, true));
        inv.add(new Vehicle("Chevy Silverado", 2016, 35000, true));
    }

    @Test
    public void loadDataTest() throws IOException {
        dealer.loadData("https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt");
    }

    @Test
    public void serializeDealerTest() {
        dealer.serializeDealer();
    }

    @Test
    public void deserializeDealerTest() {
        dealer.deserializeDealer();
    }

    @Test
    public void generateReportTest() throws IOException {
        // Deletes the file if it exists and then asserts that it does not exist
        File report = new File("report.txt");
        if (report.exists()) {
            FileUtils.forceDelete(new File("report.txt"));
        }
        Assert.assertFalse(report.exists());

        // Fills the inventory with Vehicles, generates the report, the file should now exist
        fillInventory();
        dealer.generateReport(inv);
        Assert.assertTrue(report.exists());

        // Scanner is used to read report.txt. The loop asserts that it equals the toString
        Scanner scan = new Scanner(report);
        int size = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Assert.assertEquals(line + "\n", inv.get(size).toString());
            System.out.println("Expected: " + line);
            System.out.println("Actual: " + inv.get(size).toString());
            size++;
        }
    }
}
