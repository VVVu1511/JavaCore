package RunningThreads;

import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String[] args){
        System.out.println("Thread is running");
        
        try{
            System.out.println("Main thread paused for 1 second");
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + "should take 10 dots");
            for(int i = 0; i < 10; i++){
                System.out.println(". ");
                try{
                    Thread.sleep(500);
                    
                } catch(InterruptedException e){
                    System.out.println("Whoops" + tname + "Interrupted");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + tname + " completed.");
        });

        Thread installedThread = new Thread(() -> {
            try{
                for(int i = 0; i < 3; i++){
                    Thread.sleep(250);
                    System.out.println("Installation Step " + (i + 1) +
                    " is completed");
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }, "Installed Thread");


        
        Thread threadMonitor = new Thread(()->{
            long now = System.currentTimeMillis();
            while (thread.isAlive()) {
                try{
                    Thread.sleep(100);
                    

                    if(System.currentTimeMillis() - now > 8000){
                        thread.interrupt();
                    } 
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        
        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();


        try{
            thread.join();
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        if(!thread.isInterrupted()){
            installedThread.start();
        }
        else{
            System.out.println("Previous thread was interrupted, " +
            installedThread.getName() + " can't run.");
        }
    }
}
