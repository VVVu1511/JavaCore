package Exception;

import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 0;
        int []c = {1,2,3,4};
        
        System.out.println("result:" + divide(a, b) + outArray(c, 5)); 

        try(FileReader fr = new FileReader("cry.txt")){

            fr.read();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static int divide(int a,int b){
        try{
            return a / b; 
        } catch(ArithmeticException e){
            System.out.println(e.getMessage());
            try{
                Thread.sleep(10000);
            } catch(InterruptedException v){
                System.out.println("wtf are you doing here!");
            }
        }

        return 0;
    }

    private static int outArray(int []array, int idx){
        try{
            return array[idx];
        } catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return 0;
    }

    int goToTheMoon(){
        return -1;
    }
}
