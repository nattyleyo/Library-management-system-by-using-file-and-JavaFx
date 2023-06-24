import Account.BookInfo;
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

public class BookInfoController implements Initializable {
        @FXML
    private TextField ISBN_field;

    @FXML
    private Label alert_label1;

    @FXML
    private TextField author_field;

    @FXML
    private Button bookAdd_btn;

    @FXML
    private Button bookDelete_btn;

    @FXML
    private Button bookInfo_btn;

    @FXML
    private Button bookNew_btn;

    @FXML
    private TextField bookSearch_label;

    @FXML
    private TextField bookStatus_field;

    @FXML
    private Button bookUpdate_btn;

    @FXML
    private TextField category_field;

    @FXML
    private TableColumn<BookInfo,String> col_ISBN;

    @FXML
    private TableColumn<BookInfo,String> col_author;

    @FXML
    private TableColumn<BookInfo,String> col_bookStatus;

    @FXML
    private TableColumn<BookInfo,String> col_category;

    @FXML
    private TableColumn<BookInfo,String> col_edition;

    @FXML
    private TableColumn<BookInfo,String> col_price;

    @FXML
    private TableColumn<BookInfo,String> col_quantity;

    @FXML
    private TableColumn<BookInfo,String> col_title;

    @FXML
    private Button editLibAccount_btn;

    @FXML
    private TextField edition_field;

    @FXML
    private Button issueBook_btn;

    @FXML
    private TableView<BookInfo> bookTable;


    @FXML
    private Button libLogout_btn;

    @FXML
    private TextField price_field;

    @FXML
    private TextField quantity_field;

    @FXML
    private TextField title_field;

    String[] tempArr=new String[8];

    int index;

     String ISBN;
     String bookTitle;
     String author;
     String category;
     String edition;
     String price;
     String quantity;
     String bookStatus;

    @FXML
    void bookNew(ActionEvent event) {

        ISBN_field.setText("");
        title_field.setText("");
        author_field.setText("");
        category_field.setText("");
        edition_field.setText("");
        price_field.setText("");
        quantity_field.setText("");
        bookStatus_field.setText("");
    }

    @FXML
    void bookAdd(ActionEvent event) {
        assignArray(tempArr);
        if (tempArr[0].isEmpty() || tempArr[1].isEmpty() || tempArr[2].isEmpty() ||
                tempArr[3].isEmpty()|| tempArr[4].isEmpty()|| tempArr[5].isEmpty()||
                tempArr[6].isEmpty()|| tempArr[7].isEmpty()) {
            alert_label1.setText("Please fill all Information below....!!!");
        } else {
            WriteOnFile writer = new WriteOnFile();

            BookInfo book = new BookInfo(tempArr);
            bookTable.getItems().add(book);

            alert_label1.setText("[" + book.getBookTitle() + " ] Added successfully...");
            String singleline = writer.setDataFile("BookInfo.txt", tempArr, true);
            System.out.println("File has recorded successfully");
        }
    }
    @FXML
    void bookDelete(ActionEvent event) {

        if(index<0){
            alert_label1.setText("Please select Information tobe deleted  !!!");
        }
        else{
            System.out.print("Record deleted information :");
            for(int i=0;i<tempArr.length;i++) {
                System.out.print(tempArr[i] + "-");
            }
            System.out.println("\n");
            bookTable.getItems().remove(index);
            OprationOnFile del=new OprationOnFile();
            String lineContent="";
            for(int i=0;i<tempArr.length;i++) {
                lineContent= lineContent + tempArr[i] + "-";
            }
            try {
                del.remover(lineContent,"BookInfo.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            alert_label1.setText( "User ["+tempArr[1]+"] issue Information Successfully deleted  !!!");
        }
    }
    @FXML
    void bookUpdate(ActionEvent event) {
        bookDelete(event);
        System.out.print("Record Updated information :");
        bookAdd(event);
        assignArray(tempArr);
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
            main.changeScene("LibAccount.fxml", "***********{ Account Configuration }************",700 ,600,true);
        }catch (Exception e){
            System.out.println("LibAccount FXML not found");
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
        main.changeScene("Login.fxml","************{ LOGIN }************",700,600,true);

    }



    public void assignArray(String[] tempArr){
        tempArr[0] = ISBN_field.getText();
        tempArr[1] = title_field.getText();
        tempArr[2] = author_field.getText();
        tempArr[3] = category_field.getText();
        tempArr[4] = edition_field.getText();
        tempArr[5] = price_field.getText();
        tempArr[6] = quantity_field.getText();
        tempArr[7] = bookStatus_field.getText();

    }
    public void table(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("BookInfo.txt"));
            try {
                String line;
                while ((line=reader.readLine())!=null) {
                    tempArr = line.split("-");
                    ISBN=tempArr[0];
                    bookTitle=tempArr[1];
                    author=tempArr[2];
                    category=tempArr[3];
                    edition=tempArr[4];
                    price=tempArr[5];
                    quantity=tempArr[6];
                    bookStatus=tempArr[7];
                    BookInfo issue = new BookInfo( ISBN,bookTitle,author,category,edition,price,quantity,bookStatus);
                    bookTable.getItems().add(issue);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        selection();
        col_ISBN.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("ISBN"));
        col_title.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("bookTitle"));
        col_author.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("author"));
        col_category.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("category"));
        col_edition.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("edition"));
        col_price.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("price"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("quantity"));
        col_bookStatus.setCellValueFactory(new PropertyValueFactory<BookInfo,String>("bookStatus"));

    }
    public void selection(){
        bookTable.setRowFactory(tv -> {
            TableRow<BookInfo> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                    index = bookTable.getSelectionModel().getSelectedIndex();
                    ISBN_field.setText(bookTable.getItems().get(index).getISBN());
                    title_field.setText(bookTable.getItems().get(index).getBookTitle());
                    author_field.setText(bookTable.getItems().get(index).getAuthor());
                    category_field.setText(bookTable.getItems().get(index).getCategory());
                    edition_field.setText(String.valueOf(bookTable.getItems().get(index).getEdition()));
                    price_field.setText(bookTable.getItems().get(index).getPrice());
                    quantity_field.setText(bookTable.getItems().get(index).getQuantity());
                    bookStatus_field.setText(bookTable.getItems().get(index).getBookStatus());

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
