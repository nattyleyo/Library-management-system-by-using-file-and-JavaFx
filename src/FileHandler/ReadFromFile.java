package FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public boolean getDataChecker(String url,String search_Field1,String search_Field2,int index) throws IOException {
        String filename = url;
        boolean found = false;
            try (
                FileReader fr=new FileReader(filename);
                BufferedReader reader=new BufferedReader(fr)){
                String line;
                while((line=reader.readLine())!=null){
                    String[] tempArr=line.split("-");
                        if(tempArr[index].equals(search_Field1)&&tempArr[index+1].equals(search_Field2)){
                            found=true;
                            break;
                        }
                }
    } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return found;
    }

    public String getDataline(String url,String[] strdata,int index) throws IOException {
        String line="";
        try{
                BufferedReader reader=new BufferedReader(new FileReader(url));
        while((line=reader.readLine())!=null) {
            System.out.println(line);
            String[] tempArr = line.split("-");
            if (strdata[0].equals(tempArr[index]) && strdata[1].equals( tempArr[index+1])) {
                break;
            }
            else{
                System.out.println("not found");}
        }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(line);
        return line;
    }
}
