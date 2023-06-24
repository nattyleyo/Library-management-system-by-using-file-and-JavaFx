package Account;

public class IssueBook {
    private String username;
    private String fullname;
    private String ISBN;
    private String bookTitle;
    private String issuedDate;
    private String deadline;

    public IssueBook(String username, String fullname, String ISBN, String bookTitle, String issuedDate, String deadline) {
        this.username = username;
        this.fullname = fullname;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.issuedDate = issuedDate;
        this.deadline = deadline;
    }

    public IssueBook(String[] tempArr) {
        this.username = tempArr[0];
        this.fullname = tempArr[1];
        this.ISBN = tempArr[2];
        this.bookTitle = tempArr[3];
        this.issuedDate = tempArr[4];
        this.deadline = tempArr[5];
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
