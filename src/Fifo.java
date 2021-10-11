import java.util.LinkedList;

public class Fifo {
    LinkedList<String> elements = new LinkedList<String>();

    public synchronized void put(String s) throws InterruptedException {
        System.out.println("put "+Thread.currentThread());
        while(elements.size()>=10) {
            this.wait();
        }
        elements.add(s);
        this.notify();
        System.out.println("produced "+s+" "+System.currentTimeMillis()%100000);
    }

    public synchronized String get() throws InterruptedException {
        System.out.println("get "+Thread.currentThread());
        while(elements.size()<=0) {
            this.wait();
        }
        String read = elements.get(0);
        elements.remove(read);
        this.notify();
        return read;
    }
}
