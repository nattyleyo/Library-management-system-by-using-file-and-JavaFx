import Account.IssueBook;
import FileHandler.OprationOnFile;
import FileHandler.WriteOnFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IssueBookController implements Initializable {

    @FXML
    private Button AddIssue_btn;

    @FXML
    private TextField ISBN_field;

    @FXML
    private Button NewIssue_btn;

    @FXML
    private Label alert_label1;

    @FXML
    private Label alert_label2;

    @FXML
    private Button bookInfo_btn;

    @FXML
    private TableView<IssueBook> bookIssueTable;

    @FXML
    private TextField bookSearch_label;

    @FXML
    private TableColumn<IssueBook,String> col_ISBN;

    @FXML
    private TableColumn<IssueBook,String> col_deadline;

    @FXML
    private TableColumn<IssueBook,String> col_fullname;

    @FXML
    private TableColumn<IssueBook,String> col_issueDate;

    @FXML
    private TableColumn<IssueBook,String> col_title;

    @FXML
    private TableColumn<IssueBook,String> col_username;

    @FXML
    private Button editLibAccount_btn;

    @FXML
    private TextField fullname_field;

    @FXML
    private Button issueBook_btn;

    @FXML
    private TextField issueDate_filed;

    @FXML
    private TextField issueDeadline_filed;

    @FXML
    private Button libLogout_btn;

    @FXML
    private Button removeIssue_btn;

    @FXML
    private TextField title_field;

    @FXML
    private Button updateIssue_btn;

    @FXML
    private TextField username_field;

    String[] tempArr=new String[6];

    int index;

    String username;
    String fullname;
    String ISBN;
    String bookTitle;
    String issuedDate;
    String deadline;


    @FXML
    void NewIssue(ActionEvent event) {
        username_field.setText("");
        fullname_field.setText("");
        ISBN_field.setText("");
        title_field.setText("");
        issueDate_filed.setText("");
        issueDeadline_filed.setText("");

    }

    @FXML
    void AddIssue(ActionEvent event) {
        assignArray(tempArr);
        if (tempArr[0].isEmpty() || tempArr[1].isEmpty() || tempArr[2].isEmpty() ||
                tempArr[3].isEmpty()|| tempArr[4].isEmpty()|| tempArr[5].isEmpty()) {
            alert_label1.setText("Please fill all Information below!!!");
        }
        else {
            WriteOnFile writer = new WriteOnFile();
            IssueBook issue = new IssueBook(tempArr);
            bookIssueTable.getItems().add(issue);
            alert_label1.setText("["+username+" ] issued book successfully...");
            String singleline = writer.setDataFile("IssueBook.txt", tempArr, true);
            System.out.println("File has recorded successfully");
        }
    }
    @FXML
    void removeIssue(ActionEvent event) {
        if(index<0){
            alert_label1.setText("Please select Information tobe deleted  !!!");
        }
        else{
            System.out.print("Record deleted information :");
            for(int i=0;i<tempArr.length;i++) {
                System.out.print(tempArr[i] + "-");
            }
            System.out.println("\n");
            bookIssueTable.getItems().remove(index);
            OprationOnFile delet=new OprationOnFile();
            String lineContent="";
            for(int i=0;i<tempArr.length;i++) {
                lineContent= lineContent + tempArr[i] + "-";
            }
            try {
                delet.remover(lineContent,"IssueBook.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            alert_label1.setText( "User ["+tempArr[1]+"] issue Information Successfully deleted  !!!");
        }

    }

    @FXML
    void updateIssue(ActionEvent event) {
        removeIssue(event);
        assignArray(tempArr);
        AddIssue(event);
        System.out.print("Record Updated information :");
        for(int i=0;i<tempArr.length;i++) {
            System.out.print(tempArr[i] + "-");
        }

    }
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
    void bookSearch(ActionEvent event) {

    }

    @FXML
    void editLibAccount(ActionEvent event) {
        Main main = new Main();
        try {
            main.changeScene("LibAccount.fxml", "***********{ Librarian SetUp }************",700 ,600,false);
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
    void libLogout(ActionEvent event) {
        Main main=new Main();
        main.changeScene("Login.fxml","************{ LOGIN }************",700,600,false);
    }


    public void assignArray(String[] tempArr){
        tempArr[0] = username_field.getText();
        tempArr[1] = fullname_field.getText();
        tempArr[2] = ISBN_field.getText();
        tempArr[3] = title_field.getText();
        tempArr[4] = issueDate_filed.getText();
        tempArr[5] = issueDeadline_filed.getText();

    }
    public void table(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("IssueBook.txt"));
            try {
                String line;
                while ((line=reader.readLine())!=null) {
                    tempArr = line.split("-");
                    username = tempArr[0];
                    fullname = tempArr[1];
                    ISBN = tempArr[2];
                    bookTitle = tempArr[3];
                    issuedDate=tempArr[4];
                    deadline = tempArr[5];
                    IssueBook issue = new IssueBook(username,fullname, ISBN,bookTitle,issuedDate,deadline);
                    bookIssueTable.getItems().add(issue);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        selection();
        col_username.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("username"));
        col_fullname.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("fullname"));
        col_ISBN.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("ISBN"));
        col_title.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("bookTitle"));
        col_issueDate.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("issuedDate"));
        col_deadline.setCellValueFactory(new PropertyValueFactory<IssueBook,String>("deadline"));

    }
    public void selection(){
        bookIssueTable.setRowFactory(tv -> {
            TableRow<IssueBook> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                    index = bookIssueTable.getSelectionModel().getSelectedIndex();
                    username_field.setText(bookIssueTable.getItems().get(index).getUsername());
                    fullname_field.setText(bookIssueTable.getItems().get(index).getFullname());
                    ISBN_field.setText(bookIssueTable.getItems().get(index).getISBN());
                    title_field.setText(bookIssueTable.getItems().get(index).getBookTitle());
                    issueDate_filed.setText(String.valueOf(bookIssueTable.getItems().get(index).getIssuedDate()));
                    issueDeadline_filed.setText(bookIssueTable.getItems().get(index).getDeadline());
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
