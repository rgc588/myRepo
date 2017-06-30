package observer;

/**
 * Created by cheng on 6/15/2017.
 */
public interface Listener {
    void onEvent();
    void register(Publisher p);
}
