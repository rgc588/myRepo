package annotation;

/**
 * Created by cheng on 6/25/2017.
 */
@RequestLimiter(count = 10, time = 60)
public class Request {
    public void request(int time) {
        System.out.print("At time:" + time + " Request processed\n");
    }
}
