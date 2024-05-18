package com.java.anup.states;

import com.java.anup.models.Product;
import com.java.anup.models.ProductShelf;
import com.java.anup.models.VendingMachine;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Map;
import java.util.Scanner;

public class ProductSelectState implements State{
    private VendingMachine vendingMachine;
    private Scanner scanner;
    public ProductSelectState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        scanner = new Scanner(System.in);
    }
    @Override
    public void ChooseProduct() {
        boolean wantoselectmoreproducts=true;
        vendingMachine.setCurrentState(vendingMachine.getProductSelectState());
        while(wantoselectmoreproducts)
        {
            System.out.println("Please select product from catalog");
            vendingMachine.DisplayInventory();
            System.out.println("Enter the shelf code of the product you want to select");
            String shelfCode = scanner.nextLine();
            if(shelfCode.isEmpty())
            {
                System.out.println("Please enter a valid shelf code");
                return;
            }
            else {
                ProductShelf shelf=null;
                for(ProductShelf productShelf : vendingMachine.getInventory())
                {
                    if(productShelf.getShelfCode().equals(shelfCode))
                    {
                        shelf=productShelf;
                    }
                }
                if(shelf!=null && shelf.getQuantity()>0)
                {
                    int quantitySelected=0;
                    if(vendingMachine.getProductsSelected().containsKey(shelfCode))
                        quantitySelected=vendingMachine.getProductsSelected().get(shelfCode);

                    int quantityAvailable=shelf.getQuantity();
                    Product productSelected=shelf.getProduct();

                    if(quantitySelected+1>quantityAvailable)
                    {
                        System.out.println("Product is not available.Please select a different product");
                        return;
                    }
                    vendingMachine.getProductsSelected().put(shelfCode,quantitySelected+1);
                    for(ProductShelf productShelf: vendingMachine.getInventory())
                    {
                        if(productShelf.getShelfCode().equals(shelfCode))
                        {
                            productShelf.setQuantity(shelf.getQuantity()-1);
                        }
                    }
                    vendingMachine.setTotalAmounttobePaid(vendingMachine.getTotalAmounttobePaid()+productSelected.getPrice());
                    System.out.println("Product is available and is selected. Total amount to be paid: "+vendingMachine.getTotalAmounttobePaid());

                }
                else
                {
                    System.out.println("Product is not available.Please select a different product");
                }
            }
            System.out.println("Do you want to select more products? Press Y for Yes and N for No");
            String selection = scanner.nextLine();
            if(!selection.equalsIgnoreCase("Y"))
            {
                wantoselectmoreproducts=false;
            }
        }

    }
    @Override
    public void CollectMoney() {
        vendingMachine.setCurrentState(vendingMachine.getMoneyCollectedState());
        vendingMachine.getCurrentState().CollectMoney();
    }

    @Override
    public void DispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getDispenseProductState());
        vendingMachine.getCurrentState().DispenseProduct();
    }

    @Override
    public void CancelTransaction() {
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
        vendingMachine.getCurrentState().CancelTransaction();
    }

    @Override
    public void NotifyAdminUsers() {
        System.out.println("Invalid Operation. We are in Select product stage .Please select the product first or do the payment for the selected products or Dispense products.");
    }
}
