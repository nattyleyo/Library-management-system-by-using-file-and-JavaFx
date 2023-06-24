import FileHandler.ReadFromFile;
import FileHandler.WriteOnFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminAccountController {

    @FXML
    private Button adminLogout_btn;

    @FXML
    private PasswordField adminNewpass_field;

    @FXML
    private PasswordField adminOldpass_field;

    @FXML
    private TextField adminUsername_field;

    @FXML
    private Label alert_label1;

    @FXML
    private Button editAdminAccount_btn;

    @FXML
    private Button libInfo_btn;

    @FXML
    private Button saveAdmin_btn;

    @FXML
    void adminLogout(ActionEvent event) {
        Main main=new Main();
        main.changeScene("Login.fxml","************{ LOGIN }************",700,600,false);
    }

    @FXML
    void editAdminAccount(ActionEvent event) {

        Main main = new Main();
        try {
            main.changeScene("AdminAccount.fxml", "***********{ ADMIN SetUp }************", 700, 600,false);
        }catch (Exception e){
            System.out.println("Admin FXML not found");
        }
    }

    @FXML
    void libInfo(ActionEvent event) {
        Main main=new Main();
        main.changeScene("Admin.fxml","************{ Librarian Info }************",1320,750,true);

    }

    @FXML
    void saveAdmin(ActionEvent event) throws IOException {
        Main main=new Main();
        ReadFromFile read = new ReadFromFile();
        boolean found = read.getDataChecker("AdminInfo.txt",adminUsername_field.getText(),adminOldpass_field.getText(),0);
        if (found) {
            WriteOnFile write=new WriteOnFile();
            String[] strdata=new String[2];
            strdata[0]=adminUsername_field.getText();
            strdata[1]=adminNewpass_field.getText();
            write.setDataFile("AdminInfo.txt",strdata,false);
            alert_label1.setText("Admin Account Configured successfully...");
        }
        else {
            alert_label1.setText("Admin username or password are incorrect..!!");
        }
    }
 }
