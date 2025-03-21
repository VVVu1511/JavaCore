import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static int getSumOfArray(int []array, int N){
        int result = 0;
        for(int i = 0; i < N; i++){
            result += array[i];
        }

        return result;
    }
    public static void main(String[] args) {
        // int test = 10 | 3;
        // System.out.println(test);

        // int arr[][] = {{1,2,3}, {4,5,6}};
        // for(int row[] : arr){
        //     for(int num : row){
        //         System.out.println(num);
        //     }
        // }

        // char unicodeChar = '\u0041';
        // char Char2 = 'A';

        // System.out.println(Char2);
        
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter a size of array: ");
        // int size = sc.nextInt();
        // int []array = new int[size];

        // for(int i = 0; i < size; i++){
        //     System.out.print("Enter value for element " + (i + 1) + ": ");
        //     array[i] = sc.nextInt();
        // }

        // System.out.print("Sum of array: " + getSumOfArray(array, size));

        // LocalDate date = LocalDate.of(1999,2,12);
        // Date date2 = new Date();
        // String str = String.format("Current Date / Time: %tc", date2);

        // System.out.printf(str);

        try{
            long start = System.currentTimeMillis();
            // System.out.println(new Date());

            Thread.sleep(1000 * 5);

            // System.out.println(new Date());

            long end = System.currentTimeMillis();

            System.out.println("Difference is " + (end - start));
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
