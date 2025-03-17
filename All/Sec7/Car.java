
public class Car {
    private String make = "Tesla";
    private String model = "Model X";
    private String color = "Red";
    private int doors = 2;
    private boolean convertible = true;

    public String getMake(){
        return make;
    }

    public void describeCar(){
        System.out.println(doors + "--Dooor"
        + make 
        + model 
        + color 
        + convertible);
    }
}

class Vip{

}
