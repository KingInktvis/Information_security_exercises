package exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    public FileIO(){

    }

    public StringBuilder readFile(String file) {
        //http://stackoverflow.com/a/4716623
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("res/2017.enc"))) {
            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                text.append(line);
            }
        }catch (IOException e){
            System.out.print(e);
        }
        return text;
    }
}
