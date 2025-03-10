package Challenge1;


class OddThread extends Thread{
    @Override
    public void run(){

        for(int i = 1; i <= 10; i += 2){
            System.out.println("OddThread: " + i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("OddThread interrupted.");
                break;
            }
        }
    }

}

class EvenRunnable implements Runnable{
    @Override
    public void run(){

        for(int i = 2; i <= 10; i += 2){
            System.out.println("EvenRunnable: " + i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("EvenRunnable interrupted.");
                break;
            }
        }
    }
}

public class Main {
    
    public static void main(String[] args){
        OddThread odd = new OddThread();
        
        Runnable runnable = () -> {
            for(int i = 2; i <= 10; i += 2){
                System.out.println("EvenRunnable: " + i);
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    System.out.println("EvenRunnable interrupted.");
                    break;
                }
            }
        };
        
        Thread even = new Thread(new EvenRunnable());

        odd.start();
        even.start();

        try{
            Thread.sleep(4000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        odd.interrupt();
        even.interrupt();

    }

}
