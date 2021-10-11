import java.lang.Thread;

public class Producer implements Runnable/*extends Thread*/{
    private String _message;
    private Fifo _fifo;
    private int _wait;

    public Producer(Fifo fifo,String message,int wait) {
        _message = message;
        _fifo = fifo;
        _wait = wait;
    }

    public void go() throws InterruptedException{
        int i = 0;
        while(true) {
            //System.out.println(_message +" "+i+" "+System.currentTimeMillis()%100000);
            _fifo.put(_message+" "+i++);
            Thread.sleep(_wait);
        }
    }

    public void run() {
        try {
            go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
