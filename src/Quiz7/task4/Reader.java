package Quiz7.task4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    String result = "";


  try(FileReader reader = new FileReader()){
        int c = 0;
        String character = "";
        while((c = reader.read()) != -1){
            character += (char)c;
            if(character.length() == 7){
                int charCode = Integer.parseInt(character, 2);
                result += (char) charCode;
                character = "";
            }
        }
    }
    catch(IOException e){
        e.printStackTrace();
    }
    return result;
}
