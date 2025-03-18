public class Main {
    public static void main(String[] args) {
        int test = 10 | 3;
        System.out.println(test);

        int arr[][] = {{1,2,3}, {4,5,6}};
        for(int row[] : arr){
            for(int num : row){
                System.out.println(num);
            }
        }
    }
}
