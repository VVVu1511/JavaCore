package Sec11;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product){}

public class Store {
    
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();
    
    public static void main(String[] args) {
        
        storeProducts.add(new ArtObject("Oil painting", 1350, "Vip work"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work"));
        storeProducts.add(new Furniture("Desk", 500, "Good"));
        storeProducts.add(new Furniture("Chair", 1500, "Should sit here!"));
        storeProducts.add(new Furniture("Gold meat", 150000, "Kobe"));

        listProducts();
        System.out.println("\nOrder1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    
        System.out.println("\nOrder3");
        var order3 = new ArrayList<OrderItem>();
        addItemToOrder(order3, 4, 5);
        printOrder(order3);
    }

    public static void listProducts(){
        for(var item : storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order,int orderIndex,int qty){
        order.add(new OrderItem(qty,storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for(var item : order){
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n",salesTotal);
    }
}
