package Account;

public class BookInfo {
    private String ISBN;
    private String bookTitle;
    private String author;
    private String category;
    private String edition;
    private String price;
    private String quantity;
    private String bookStatus;

    public BookInfo(String ISBN, String bookTitle, String author,
                    String category, String edition, String price, String quantity, String bookStatus) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.author = author;
        this.category = category;
        this.edition = edition;
        this.price = price;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public BookInfo(String[] tempArr) {
        this.ISBN = tempArr[0];
        this.bookTitle = tempArr[1];
        this.author = tempArr[2];
        this.category = tempArr[3];
        this.edition = tempArr[4];
        this.price = tempArr[5];
        this.quantity = tempArr[6];
        this.bookStatus = tempArr[7];
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = catagory;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
