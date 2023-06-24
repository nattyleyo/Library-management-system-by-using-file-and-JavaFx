import Account.Librarian;
import FileHandler.OprationOnFile;
import FileHandler.WriteOnFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminController implements Initializable {
    @FXML
    private TableView<Librarian> libData_table;
    @FXML
    private TableColumn<Librarian, String> col_address;

    @FXML
    private TableColumn<Librarian, String> col_email;

    @FXML
    private TableColumn<Librarian, String> col_name;

    @FXML
    private TableColumn<Librarian, String> col_pass;

    @FXML
    private TableColumn<Librarian,Long> col_phone;

    @FXML
    private TableColumn<Librarian, String> col_username;


    @FXML
    private Button editAdminAccount_btn;

    @FXML
    private TextField libAddress_field;

    @FXML
    private TextField libDataSearch_label;

    @FXML
    private TextField libEmail_field;

    @FXML
    private TextField libFullname_field;

    @FXML
    private Button libINewData_btn;

    @FXML
    private Button libInfoDelete_btn;

    @FXML
    private Button libInfoUpdate_btn;

    @FXML
    private Button libInfo_btn;

    @FXML
    private Button adminLogout_btn;

    @FXML
    private PasswordField libPassword_field;

    @FXML
    private TextField libPhoneNo_field;

    @FXML
    private TextField libUsername_field;

    @FXML
    private Button libinfoAdd_btn;
    @FXML
    private Label alert_label1;

    @FXML
    private Label alert_label11;

    String[] tempArr=new String[6];

    int index;
    String fullname;
    String username;
    String password;
    String email;
    String phone;
    String address;

    @FXML
    void libNew(ActionEvent event){
        libFullname_field.setText("");
        libUsername_field.setText("");
        libPassword_field.setText("");
        libEmail_field.setText("");
        libPhoneNo_field.setText("");
        libAddress_field.setText("");
    }
    @FXML
    void libDataAdd(ActionEvent events) {
        assignArray(tempArr);
        if (tempArr[0].isEmpty() || tempArr[1].isEmpty() || tempArr[2].isEmpty() ||
                tempArr[3].isEmpty()|| tempArr[4].isEmpty()|| tempArr[5].isEmpty()) {
            alert_label1.setText("Please fill all Information below...!!!");
        } else {
            WriteOnFile writer = new WriteOnFile();

            Librarian lib = new Librarian(tempArr);
            System.out.println("line:"+tempArr[0]);

            libData_table.getItems().add(lib);
            alert_label1.setText("["+username+" ] added as Librarian successfully...");
            String singleline = writer.setDataFile("LibrarianInfo.txt", tempArr, true);
            System.out.println("written on txt successfully");
        }

    }
    @FXML
    void libDataDelete(ActionEvent event) throws IOException {
        if(index<0){
            alert_label1.setText("Please select Information tobe deleted  !!!");
        }
        else{
        System.out.print("deleted information :");
        for(int i=0;i<tempArr.length;i++) {
            System.out.print(tempArr[i] + "-");
        }
        System.out.println("\n");
        libData_table.getItems().remove(index);
        OprationOnFile del=new OprationOnFile();
        String lineContent="";
        for(int i=0;i<tempArr.length;i++) {
            lineContent= lineContent + tempArr[i] + "-";
        }
        try {
            del.remover(lineContent,"LibrarianInfo.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        alert_label1.setText( "User ["+tempArr[1]+"]Successfully deleted  !!!");
        }

    }
    @FXML
    void libDataUpdate(ActionEvent event) throws IOException {
        libDataDelete(event);
        assignArray(tempArr);
        libDataAdd(event);
        System.out.print("Updated information :");
        for(int i=0;i<tempArr.length;i++) {
            System.out.print(tempArr[i] + "-");
        }

    }

    @FXML
    void libDataSearch(ActionEvent event) {
        Librarian selecteItem=libData_table.getSelectionModel().getSelectedItem();
        libFullname_field.setText(selecteItem.getFullname());
        libUsername_field.setText(selecteItem.getUsername());
        libPassword_field.setText(selecteItem.getPassword());
        libPhoneNo_field.setText(String.valueOf(selecteItem.getPhone()));
        libEmail_field.setText(selecteItem.getEmail());
        libAddress_field.setText(selecteItem.getAddress());

        int selectdId=libData_table.getSelectionModel().getSelectedIndex();
        String libInfo=libData_table.getItems().toString();
        libData_table.getItems().remove(selectdId);


    }



    public void libInfo(ActionEvent actionEvent) {

        Main main=new Main();
        main.changeScene("Admin.fxml","************{ Librarian Information }************",1320,750,true);

    }

    public void editAdminAccount(ActionEvent actionEvent) {

        Main main = new Main();
        try {
            main.changeScene("AdminAccount.fxml", "***********{ ADMIN SetUp }************", 700, 600,false);
        }catch (Exception e){
            System.out.println("Admin FXML not found");
        }
    }

    public void adminLogout(ActionEvent actionEvent) {
        Main main=new Main();
        main.changeScene("Login.fxml","************{ LOGIN }************",700,600,false);

    }

    public void assignArray(String[] tempArr){
        tempArr[0] = libFullname_field.getText();
        tempArr[1] = libUsername_field.getText();
        tempArr[2] = libPassword_field.getText();
        tempArr[3] = libEmail_field.getText();
        tempArr[4] = libPhoneNo_field.getText();
        tempArr[5] = libAddress_field.getText();

    }
    public void table(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Natty\\OneDrive\\Desktop\\Project\\javaG9\\LibrarianInfo.txt"));
            try {
                String line;
                while ((line=reader.readLine())!=null) {
                     tempArr = line.split("-");
                    fullname = tempArr[0];
                    username = tempArr[1];
                    password = tempArr[2];
                    email = tempArr[3];
                    phone = tempArr[4];
                    address = tempArr[5];
                    Librarian lib = new Librarian(fullname, username, password, email, phone, address);
                    libData_table.getItems().add(lib);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);}

        selection();
        col_name.setCellValueFactory(new PropertyValueFactory<Librarian,String>("fullname"));
        col_username.setCellValueFactory(new PropertyValueFactory<Librarian,String>("username"));
        col_pass.setCellValueFactory(new PropertyValueFactory<Librarian,String>("password"));
        col_email.setCellValueFactory(new PropertyValueFactory<Librarian,String>("email"));
        col_phone.setCellValueFactory(new PropertyValueFactory<Librarian,Long>("phone"));
        col_address.setCellValueFactory(new PropertyValueFactory<Librarian,String>("address"));

    }
    public void selection(){
        libData_table.setRowFactory(tv -> {
            TableRow<Librarian> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

        index = libData_table.getSelectionModel().getSelectedIndex();
        libFullname_field.setText(libData_table.getItems().get(index).getFullname());
        libUsername_field.setText(libData_table.getItems().get(index).getUsername());
        libPassword_field.setText(libData_table.getItems().get(index).getPassword());
        libEmail_field.setText(libData_table.getItems().get(index).getEmail());
        libPhoneNo_field.setText(String.valueOf(libData_table.getItems().get(index).getPhone()));
        libAddress_field.setText(libData_table.getItems().get(index).getAddress());
        assignArray(tempArr);
               }
            });
            return myRow;
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       table();

    }
}


