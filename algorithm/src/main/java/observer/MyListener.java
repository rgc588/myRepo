package observer;

/**
 * Created by cheng on 6/15/2017.
 */
public class MyListener implements Listener {
    public void onEvent() {
        System.out.print("MyListener is on Event!");
    }

    public void register(Publisher publisher) {
        publisher.listeners.add(this);
    }
}
