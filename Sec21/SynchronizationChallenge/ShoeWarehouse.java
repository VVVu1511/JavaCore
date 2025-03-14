import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ShoeWarehouse {
    
    private List<Order>shippingItems;

    private final ExecutorService fulfillmentService;

    public final static String[] PRODUCT_LIST = 
    {"Running","Sandals","Boots"};

    {
        fulfillmentService = Executors.newFixedThreadPool(3);
    }

    public ShoeWarehouse(){
        this.shippingItems = new ArrayList<>();
    }

    public void shutDown(){
        fulfillmentService.shutdown();
    }

    public synchronized void receiveOrder(Order item){
        while(shippingItems.size() > 20){
            try{
                wait();
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        
        shippingItems.add(item);
        System.out.println(Thread.currentThread().getName() + " Incoming: " + item);
        fulfillmentService.submit(this::fulfillOrder);
        notifyAll();
    }

    public synchronized Order fulfillOrder(){
        while(shippingItems.isEmpty()){
            try{
                wait();
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        Order item = shippingItems.remove(0);
        System.out.println(Thread.currentThread().getName() + " Fulfilled: " + item);
        notifyAll();
        return item;
    }
}
