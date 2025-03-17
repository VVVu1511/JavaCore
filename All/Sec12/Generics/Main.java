package Sec12.Generics;

record BaseballPlayer(String name, String position){}

public class Main {
    
    public static void main(String[] args) {
        BaseballTeam phillies = new BaseballTeam("pp");
        BaseballTeam as = new BaseballTeam("as");

        System.out.println(phillies.setScore(15, 2));
    }

}
