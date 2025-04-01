package OOP;

import java.util.ArrayList;

public class Generics{
    public static void main(String[] args) {
        ArrayList<Boolean> fruits = new ArrayList<>();

        fruits.add(true);
        fruits.add(false);
        fruits.add(true);

        System.out.println(fruits);

        // Box<Double> a = new Box<>();
        
        // a.setItem(3.15);

        // System.out.println(a.getItem());

        Product<String,Double> product = new Product<>("Car",1000000.0);
        System.out.println(product.getPrice());
    }
}