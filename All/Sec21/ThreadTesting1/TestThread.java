import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

public class TestThread{
    public static void main(String[] args) throws InterruptedException {
        final ScheduledExecutorService scheduler = 
            Executors.newScheduledThreadPool(1);

        final ScheduledFuture<?> beepHandler = 
        scheduler.scheduleAtFixedRate(new BeepTask(), 1, 1, TimeUnit.SECONDS);
        
        final ScheduledExecutorService boss = 
        Executors.newScheduledThreadPool(1);

        boss.schedule(new Runnable() {
            @Override
            public void run(){
                beepHandler.cancel(true);
                scheduler.shutdown();
                System.exit(1);  
            }
        }, 10, TimeUnit.SECONDS);

        // scheduler.schedule(new Runnable(){
        //     @Override 
        //     public void run(){
        //         beepHandler.cancel(true);
        //         scheduler.shutdown();
        //         System.exit(1);                }
        // }
        //     , 10
        // , TimeUnit.SECONDS);
        }
    
    static class BeepTask implements Runnable{
        public void run() {
            for(int i = 0; i < 10000000; i++) System.out.println("Yeu Linh Dan ghe");
        }
    }
}