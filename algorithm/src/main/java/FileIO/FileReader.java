package FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 6/29/2017.
 */
public class FileReader {
    Map<String, Integer> rate = new HashMap<>();
    public void read(String filename) {
        try {
            BufferedReader in = new BufferedReader(new java.io.FileReader(new File(filename)));
            String line = "";
            while((line = in.readLine()) != null) {
                String[] strs = line.split(" ");
                rate.put(strs[0], Integer.valueOf(strs[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.print(rate);
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.read("C:\\Users\\cheng\\myRepo\\algorithm\\src\\main\\java\\FileIO\\input.txt");
        fileReader.print();
    }
}
