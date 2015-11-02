import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chengong on 10/8/15.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int max = 0;
        Map<Character, List<String>> map = new HashMap<>();

        for(int n : nums) {
            max = max < n ? n : max;
        }

        int l = 0;
        while(max > 0) {
            max /= 10;
            l++;
        }

        List<String> rst = new ArrayList<>();

        for(int n : nums) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(n));
            while(sb.length() < l) {
                sb.append(String.valueOf('0' - 1));
            }
            rst.add(sb.toString());
        }

        for(int i = 0; i < l; i++) {
            map = new HashMap<>();
            for(String str : rst) {
                char c = str.charAt(l - i - 1);
                if(map.containsKey(c)) {
                    map.get(c).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(c, list);
                }
            }
            rst = new ArrayList<>();
            for(char c = '9'; c >= '0' - 1; c--) {
                if(map.containsKey(c)) {
                    List<String> list = map.get(c);
                    for (String str : list) {
                        rst.add(str);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String str : rst) {
            sb.append(str);
        }

        return sb.toString().replaceAll("/", "");
    }

    public static void main(String[] args) {
        LargestNumber test = new LargestNumber();
        int[] input = new int[]{10};
        System.out.println(test.largestNumber(input));
    }
}
