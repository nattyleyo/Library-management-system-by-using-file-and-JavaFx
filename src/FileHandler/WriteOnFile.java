package FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOnFile {
    public String setDataFile(String url, String[] strdata,boolean ap) {
        String line="";
        try {
            File file = new File(url);
            FileWriter writer=new FileWriter(file,ap);
            PrintWriter pw=new PrintWriter(writer);
            for(int i=0;i<strdata.length;i++) {
                line = line + strdata[i] + "-";
            }
            pw.println(line);
            pw.close();
            System.out.println("witee:"+line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

}