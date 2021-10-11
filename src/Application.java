public class Application {
    public static void main(String[] args) throws InterruptedException{
        /*
        Fifo storage = new Fifo();
        Producer pr = new Producer(storage,"XD");
        Producer pr2 = new Producer(storage,"XDD");
        pr.start();
        Thread.sleep(500);
        pr2.start();*/
        /*Fifo storage = new Fifo();
        Producer pr = new Producer(storage,"producer",100);
        Consumer cr = new Consumer(storage,"consumer",1030);
        Thread t = new Thread(pr);
        Thread t2 = new Thread(cr);
        t.start();
        t2.start();*/
        Fifo storage = new Fifo();
        Thread[] threads = new Thread[7];
        for(int i = 0;i<3;i++) {
            threads[i] = new Thread(new Producer(storage,"Producer"+i,1000));
        }
        for(int i = 3;i<7;i++) {
            threads[i] = new Thread(new Consumer(storage,"Consumer"+i,100));
        }

        for(int i = 0;i<7;i++) {
            threads[i].start();
        }
    }
}
