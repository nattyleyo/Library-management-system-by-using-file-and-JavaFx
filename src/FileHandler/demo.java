package FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class demo {

    public void getDataFile(String url, String tempArr, int index) {
        File file = new File(url);
        FileReader fr = null;
        boolean found = false;
        if (file.exists()) {
            try {
                fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line;
                while ((line = reader.readLine()) != null) {
                    /*if (line.contains(tempArr[0])&&line.contains(tempArr[1])) {
                        if (tempArr2[2].equals(username_field.getText()) && tempArr2[3].equals(password_field.getText())) {
                        }
                    }*/
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("File not found!!!!");
        }
       // return bool;
    }
}
