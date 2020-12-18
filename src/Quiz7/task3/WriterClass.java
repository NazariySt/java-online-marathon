package Quiz7.task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterClass {
    public static void writeFile(String filename, String text) {
        byte[] ourBytes = text.getBytes();
        String string = "";
        for (byte bytes : ourBytes) {
            string += String.format("%7s", Integer.toBinaryString(bytes & 0xFF)).replace(' ', '0');
        }
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(string);

        } catch (IOException i) {
            i.printStackTrace();
        }

    }

}
