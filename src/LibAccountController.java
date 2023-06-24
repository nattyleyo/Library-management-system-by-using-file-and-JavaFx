import FileHandler.OprationOnFile;
import FileHandler.ReadFromFile;
import FileHandler.WriteOnFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LibAccountController {

    @FXML
    private PasswordField libNewpass_field;

    @FXML
    private PasswordField libOldpass_field;

    @FXML
    private TextField libUsername_field;

    @FXML
    private Label alert_label1;

    @FXML
    private Button bookInfo_btn;

    @FXML
    private Button editLibAccount_btn;

    @FXML
    private Button issueBook_btn;

    @FXML
    private Button libAccountSave_btn;

    @FXML
    private Button libLogout_btn;

    @FXML
    void bookInfo(ActionEvent event) {
        Main main = new Main();
        try {
            main.changeScene("BookInfo.fxml", "***********{ Book Information }************",1320 ,750,true);
        }catch (Exception e){
            System.out.println("BookInfo FXML not found");
        }
    }

    @FXML
    void editLibAccount(ActionEvent event) {
        Main main = new Main();
        try {
            main.changeScene("LibAccount.fxml", "***********{ Librarian Configuration }************",700 ,600,false);
        }catch (Exception e){
            System.out.println("Librarian FXML not found");
        }
    }

    @FXML
    void issueBook(ActionEvent event) {

        Main main=new Main();
        main.changeScene("IssueBook.fxml","************{ Issue Book }************",1320,750,true);

    }

    @FXML
    void libAccountSave(ActionEvent event) throws Exception {
        Main main=new Main();
        ReadFromFile read = new ReadFromFile();
        boolean found = read.getDataChecker("LibrarianInfo.txt",libUsername_field.getText(),libOldpass_field.getText(),1);
        if (found) {
            WriteOnFile write=new WriteOnFile();
            OprationOnFile del=new OprationOnFile();

            String[] strdata=new String[2];
            strdata[0]=libUsername_field.getText();
            strdata[1]=libOldpass_field.getText();

            String lineContent=read.getDataline("LibrarianInfo.txt",strdata,1);
            System.out.println("file: "+lineContent);

            del.remover(lineContent,"librarianInfo.txt");

            String[] temp=lineContent.split("-");
            temp[2]=libNewpass_field.getText();
            write.setDataFile("LibrarianInfo.txt",temp,true);

            alert_label1.setText("Account Configured successfully...");
        }
        else {
            alert_label1.setText(" username or password are incorrect..!!");
        }


    }

    @FXML
    void libLogout(ActionEvent event) {
        Main main=new Main();
        main.changeScene("Login.fxml","************{ LOGIN }************",700,600,false);

    }

}
