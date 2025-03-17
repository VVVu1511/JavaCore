package Sec11;

public class Meat extends ProductForSale{
    
    public Meat(String type,double price, String description){
        super(type,price,description);
    }
    
    @Override
    public void showDetails(){
        System.out.println("This " + type + " comes from the most famous pigs in the world");
        System.out.printf("The price of the piece is $%6.2f %n",price);
        System.out.println(description);
    }
}
