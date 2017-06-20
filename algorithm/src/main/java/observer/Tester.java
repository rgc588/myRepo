package observer;

/**
 * Created by cheng on 6/15/2017.
 */
public class Tester {
    public static void main(String[] args) {
        Publisher p = new Publisher();
        Listener l = new MyListener();
        l.register(p);
        p.statusUpdate();
    }
}
