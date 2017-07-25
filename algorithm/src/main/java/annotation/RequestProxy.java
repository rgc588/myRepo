package annotation;

import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cheng on 6/25/2017.
 */
public class RequestProxy {

    Request req;
    Queue<Integer> requested;
    int count;
    int time;

    RequestProxy (Request req) {
        this.req = req;
        this.requested = new LinkedList<>();
        RequestLimiter annotation = req.getClass().getAnnotation(RequestLimiter.class);
        this.count = annotation.count();
        this.time = annotation.time();
    }

    public void request(int time) {
        while(!this.requested.isEmpty() && this.requested.peek() <= time-this.time) {
            this.requested.remove();
        }
        if (this.requested.size() < count) {
            this.requested.add(time);
            this.req.request(time);
        } else {
            System.out.print("At time:" + time + " Too many request\n");
        }
    }
}
