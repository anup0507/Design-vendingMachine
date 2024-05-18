import com.java.anup.models.Product;
import com.java.anup.models.ProductShelf;
import com.java.anup.models.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Inventory for Vending Machine");
        List<ProductShelf> inventory = getProductShelves();
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine(inventory, 10);
        while(true)
        {
            System.out.println("Please select the option");
            System.out.println("1-Select Product");
            System.out.println("2-Collect Money");
            System.out.println("3-Dispense Product");
            System.out.println("4-Cancel Transaction");
            System.out.println("5-Notify Admin Users");
            System.out.println("6-Display Inventory");
            System.out.println("7-Exit");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                    vendingMachine.ChooseProduct();
                    break;
                case 2:
                    vendingMachine.CollectMoney();
                    break;
                case 3:
                    vendingMachine.DispenseProduct();
                    break;
                case 4:
                    vendingMachine.CancelTransaction();
                    break;
                case 5:
                    vendingMachine.NotifyAdminUsers();
                    break;
                case 6:
                    vendingMachine.DisplayInventory();
                    break;
                case 7:
                    vendingMachine.exit();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option selected");
                    break;
            }

        }

    }

    private static List<ProductShelf> getProductShelves() {
        ProductShelf productShelf1 = new ProductShelf("A1", new Product("Lays", 20,"Lays"), 10);
        ProductShelf productShelf2 = new ProductShelf("A2", new Product("Kurkure", 10,"Coke"), 10);
        ProductShelf productShelf3 = new ProductShelf("A3", new Product("Coke", 10,"Coke"), 10);
        ProductShelf productShelf4 = new ProductShelf("B1", new Product("Pepsi", 10,"Pepsi"), 10);
        ProductShelf productShelf5 = new ProductShelf("B2", new Product("Thums Up", 10,"Thums Up"), 10);
        ProductShelf productShelf6 = new ProductShelf("B3", new Product("Sprite", 10,"Sprite"), 10);
        ProductShelf productShelf7 = new ProductShelf("C1", new Product("Dairy Milk", 10,"Dairy Milk"), 10);
        ProductShelf productShelf8 = new ProductShelf("C2", new Product("5 Star", 10,"5 Star"), 10);
        ProductShelf productShelf9 = new ProductShelf("C3", new Product("Munch", 10,"Munch"), 10);

        List<ProductShelf> inventory = new ArrayList<>();
        inventory.add(productShelf1);
        inventory.add(productShelf2);
        inventory.add(productShelf3);
        inventory.add(productShelf4);
        inventory.add(productShelf5);
        inventory.add(productShelf6);
        inventory.add(productShelf7);
        inventory.add(productShelf8);
        inventory.add(productShelf9);
        return inventory;
    }
}