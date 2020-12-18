package Quiz7.task4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String readFile(String filename) {
        String result = "";
        try (FileReader fr = new FileReader(filename)) {
            int count = 0;
            while ((count = fr.read()) != -1) {
                result += (char) count;
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        return result;
    }
}
