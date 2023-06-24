
import Account.UserInfo;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField address_field;

    @FXML
    private TextField email_field;

    @FXML
    private TextField fullname_field;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField phoneNo_field;

    @FXML
    private Button signup_btn;

    @FXML
    private TextField username_field;

    @FXML
    private Label wrong_label;

    @FXML
    void userLogin(ActionEvent event) {

        Main main = new Main();
        main.changeScene("Login.fxml","********Login**********",700,600,false);
    }

    @FXML
    void userSignup(ActionEvent event) {
        Main main= new Main();
        UserInfo us=new UserInfo();
        if (fullname_field.getText().isEmpty()||username_field.getText().isEmpty()||password_field.getText().isEmpty()||
                email_field.getText().isEmpty()|| phoneNo_field.getText().isEmpty() || address_field.getText().isEmpty()) {
            wrong_label.setText("please fill all information !!");
        } else {
            wrong_label.setText("Congratulation registered successfully !! " +
                    "Now You can Login");
            us.fullname=fullname_field.getText();
            us.username=username_field.getText();
            us.password=password_field.getText();
            us.email=email_field.getText();
            us.phone= Long.parseLong(phoneNo_field.getText());
            us.address=address_field.getText();
        }

    }

}
