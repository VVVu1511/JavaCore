
public class GenG implements Robot,Human{
    private int age;
    private boolean experienced;

    {
        age = 0;
        experienced = false;
    }
    
    public GenG(){

    }

    public GenG(int age, boolean experienced){
        this.age = age;
        this.experienced = experienced;
    }

    public void shoot(){
        System.out.println("GenG shoots");
    }

    public void eat(){
        System.out.println("GenG eats");
    }

    public void drink(){
        System.out.println("GenG drinks");
    }

    public void sleep(){
        System.out.println("GenG sleeps");
    }

    public int getAge(){
        return age;
    }

    public boolean isExperienced(){
        return this.experienced;
    }
}
