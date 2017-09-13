package exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

    public FileIO(){

    }

    public StringBuilder readFile(String file) {
        //http://stackoverflow.com/a/4716623
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                text.append(line + "\n");
            }
        }catch (IOException e){
            System.out.print(e);
        }
        return text;
    }

    public void writeFile(String path, StringBuilder text) {
        try{
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.println(text);
            writer.close();
        } catch (IOException e) {
            // do something
        }

    }
}
