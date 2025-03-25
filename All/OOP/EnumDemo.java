package OOP;

public class EnumDemo {
    public static void main(String[] args) {
        Mobile mobile = Mobile.APPLE;

        if(mobile == Mobile.APPLE){
            System.out.println("we should attack this man!");
        }
    }

    enum Mobile{
        SAMSUNG,
        APPLE,
        ONEPLUS,
        VIVO,
        OPPO
    }
}
