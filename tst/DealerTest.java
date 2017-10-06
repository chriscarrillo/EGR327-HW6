import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
        File report = new File("report.txt");
        if (report.exists()) {
            FileUtils.forceDelete(new File("report.txt"));
        }
        Assert.assertFalse(report.exists());

        fillInventory();
        dealer.generateReport(inv);
        Assert.assertTrue(report.exists());

        Scanner scan = new Scanner(report);
        Assert.assertEquals(scan.nextLine() + "\n", inv.get(0).toString());
    }
}
