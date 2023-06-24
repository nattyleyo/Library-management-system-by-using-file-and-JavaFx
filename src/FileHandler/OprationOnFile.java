package FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OprationOnFile {

    public void remover(String lineContent,String filepath) throws Exception {
        File originalFile = new File(filepath);
        Scanner inputreader=new Scanner(originalFile);
        List<String>list=new ArrayList<>();
        while (inputreader.hasNextLine()){
            String data=inputreader.nextLine();
            if(!data.equals(lineContent)){
                list.add(data);
            }

        }
        inputreader.close();
        FileWriter fw=new FileWriter(originalFile);
        for(int i=0;i<list.size();i++){
            fw.write((String) list.get(i)+"\n");
        }
        fw.close();
    }
}

