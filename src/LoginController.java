import FileHandler.ReadFromFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController implements  Initializable {

    @FXML
    private ComboBox combobox;
    @FXML
    private Label wrong_label;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private CheckBox remind_checkbox;
    @FXML
    private Button signup_btn;
    @FXML
    private Button forgetP_btn;
    @FXML
    private Button login_btn;

    public void userLogin(ActionEvent actionEvent) throws IOException {
        String str;
        str = combobox.getSelectionModel().getSelectedItem().toString();
       if( str==null||username_field.getText().isEmpty() || password_field.getText().isEmpty()) {
            wrong_label.setText("please fill first !!");
        }
        ReadFromFile read1 = new ReadFromFile();
        ReadFromFile read2 = new ReadFromFile();
        ReadFromFile read3 = new ReadFromFile();
        boolean found;
        if (str.equals("User")) {
            found = read1.getDataChecker("UserInfo.txt", username_field.getText(), password_field.getText(), 1);
            if (found) {
                Main main = new Main();
                wrong_label.setText("Successfull Login");
                main.changeScene("sample2.fxml", "********Admin*******",700,600,true);
            } else {
                wrong_label.setText("Incorrect username or password !!");
            }
        } else if (str.equals("Librarian")) {
            found = read2.getDataChecker("LibrarianInfo.txt", username_field.getText(), password_field.getText(), 1);
            if (found) {
                Main main = new Main();
                wrong_label.setText("Successfull Login");
                main.changeScene("BookInfo.fxml", "********{ Book Information }*******",1320,750,true);
            } else {
                wrong_label.setText("Incorrect username or password !!");
            }
        } else {
            found = read3.getDataChecker("AdminInfo.txt", username_field.getText(), password_field.getText(), 0);
            if (found) {
                Main main = new Main();
                wrong_label.setText("Successfull Login");
                main.changeScene("Admin.fxml", "********Admin*******",1320,750,true);
            } else {
                wrong_label.setText("Incorrect username or password !!");
            }

        }
    }
    public void userSignup (ActionEvent actionEvent) throws IOException {
        Main main=new Main();
                    main.changeScene("SignUp.fxml","*******SignUp*********",700,600,true);
                }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"User", "Librarian", "Admin"};
        combobox.getItems().addAll(items);

    }
}


