package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 6/15/2017.
 */
public class Publisher {
    public List<Listener> listeners = new ArrayList<>();

    public void statusUpdate() {
        for (Listener listener : listeners) {
            listener.onEvent();
        }
    }
}
