public class Consumer extends Thread{
    private Fifo _f;
    private String _s;
    private int _n;

    public Consumer(Fifo f, String s, int n){
        _f = f;
        _s = s;
        _n = n;
    }

    public void run() {
        while(true) {
            try{
                System.out.println("consumed "+_s + " "+
                                    _f.get()+" "+
                                    System.currentTimeMillis()%100000);
                Thread.sleep(_n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
