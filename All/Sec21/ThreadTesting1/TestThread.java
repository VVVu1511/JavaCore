import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Executors;


public class TestThread{
    private final ReentrantLock lock = new ReentrantLock(true);

    public void operation(int n){
        if(lock.tryLock()){
            try{
                lock.lock();
                for(int i = 1; i <= 4; i++){
                    System.out.println(n++);
                }

            } finally{
                lock.unlock();
            } 
        }
        else{
            System.out.println("I am in else block");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        TestThread tt = new TestThread();

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                tt.operation(1);
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                tt.operation(5);
            }
        });

        Thread thread3 = new Thread(new Runnable(){
            @Override
            public void run() {
                tt.operation(10);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        // final ScheduledExecutorService scheduler = 
        //     Executors.newScheduledThreadPool(1);

        // final ScheduledFuture<?> beepHandler = 
        // scheduler.scheduleAtFixedRate(new BeepTask(), 1, 1, TimeUnit.SECONDS);
        
        // final ScheduledExecutorService boss = 
        // Executors.newScheduledThreadPool(1);

        // scheduler.schedule(new Runnable(){
        //     @Override 
        //     public void run(){
        //         while(!lock){
        //             scheduler.wait();
        //         }
        //         lock = false;
        //         for(int i = 0; i < 100; i++) System.out.println("Yeu Linh Dan ghe");
        //     }
        // }, 1, TimeUnit.SECONDS);
        // boss.schedule(new Runnable() {
        //     @Override
        //     public void run(){
        //         while(!lock){
        //             for(int i = 0; i < 100; i++) System.out.println("Yeu Dan Linh ghe");
        //         }
        //         lock = false;
        //         beepHandler.cancel(true);
        //         scheduler.shutdown();
        //         System.exit(1);  
        //     }
        // }, 10, TimeUnit.SECONDS);

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