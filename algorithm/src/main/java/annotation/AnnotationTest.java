package annotation;

/**
 * Created by cheng on 6/25/2017.
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Request req = new Request();
        RequestProxy reqPoxy = new RequestProxy(req);
        for (int i = 1; i < 100; i++) {
            reqPoxy.request(i);
        }
    }
}
