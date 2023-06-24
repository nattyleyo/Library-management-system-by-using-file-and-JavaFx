package Account;
public class Librarian {
    private String fullname;
    private String username;
    private String password;
    private String email;

    private String phone;
    private String address;

    public Librarian(String fullname, String username, String password, String email, String phone, String address) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Librarian(String[] tempArr) {
        this.fullname = tempArr[0];
        this.username = tempArr[1];
        this.password = tempArr[2];
        this.email = tempArr[3];
        this.phone = tempArr[4];
        this.address = tempArr[5];
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}