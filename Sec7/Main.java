public class Main{
    public static void main(String[] args){
        GenG vu = new GenG(10,true);
        System.out.println(vu.getAge());
        System.out.println(vu.isExperienced());
        vu.sleep();
    }
}