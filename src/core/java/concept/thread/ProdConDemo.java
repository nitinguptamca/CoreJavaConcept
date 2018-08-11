package core.java.concept.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConDemo {

    public static void main(String[] args) {
        // This is the shared list shared between producer
        // and consumer.. LinkedList implements Queue interface
        Queue<Integer> sharedListObj = new LinkedList<Integer>();
        Thread t1 = new Thread(new ProdClass(sharedListObj), "ProdThread");
        Thread t2 = new Thread(new ConClass(sharedListObj), "ConThread");
        t1.start();
        t2.start(); 
    }
}

// Producer class
class ProdClass implements Runnable{
    Queue<Integer> sharedListObj;
    // Constructor
    ProdClass(Queue<Integer> sharedListObj){
        this.sharedListObj = sharedListObj;
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            synchronized (sharedListObj) {
                // While condition as mandated to avoid spurious wakeup
                while(sharedListObj.size() >= 1){
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                // Putting value in the list
                System.out.println("Adding to queue - " + Thread.currentThread().getName() 
                   + " " + ++i);
                sharedListObj.add(i);
                sharedListObj.notify();    
                // To get out of while(true) loop (running 5 times only)
                if(i > 4) break;
            }
        }
    }            
}

//Consumer class
class ConClass implements Runnable{
    Queue<Integer> sharedListObj;
    // Constructor
    ConClass(Queue<Integer> sharedListObj){
        this.sharedListObj = sharedListObj;
    }
    @Override
    public void run() {    
        while(true){
            synchronized (sharedListObj) {
                while(sharedListObj.size() < 1){
                    try {
                        sharedListObj.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }                    
                }
                int val = sharedListObj.remove();
                // Getting value from the list
                System.out.println("Getting from queue " + Thread.currentThread().getName() 
                   + " " + val);
                // To get out of while(true) loop
                if(val == 5) {
                    break;
                }
                sharedListObj.notify();        
                
            }
        }
    }
}