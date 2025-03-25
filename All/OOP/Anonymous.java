package OOP;

interface Car{
    public void go();
}

public class Anonymous {
    public static void main(String[] args) {
        Car c1 = new Car(){

            @Override
            public void go(){
                System.out.println("Anonymous Car is going");
            }

        };

        c1.go();
        System.out.println(c1.getClass().getName());
    }
}
