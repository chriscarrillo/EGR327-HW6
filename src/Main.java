import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dealer dealer = new Dealer();
        dealer.loadData("https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt");
        dealer.serializeDealer();
        dealer.deserializeDealer();
    }
}
