package Thread;

class ThreadDemo extends Thread{
    ThreadDemo(){

    }

    @Override
    public void run(){

        for(int i = 0; i < 4; i++){
            System.out.println("Thread " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() +  " " + i);
        }

        try{
            Thread.sleep(50);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void start(){
        super.start();
    }
}

public class TestThread {
    public static void main(String[] args) {
        Thread thread1 = new ThreadDemo();
        Thread thread2 = new ThreadDemo();
        Thread thread3 = new ThreadDemo();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
