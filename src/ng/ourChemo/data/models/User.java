package ng.ourChemo.data.models;

public class User {

    private String  password;
    private String username;
    private String fullname;
    private int userId;
    private boolean isLoggedIn;

    public User(){

    }

    public  User(String username, String fullname, int customerId, String password) {
        this.username = username;
        this.fullname = fullname;
        this.userId = customerId;
        this.password = password;
    }
    public void setUserId(int id) {
        this.userId = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public String getFullname(){
        return fullname;
    }
    public void setPassword(String password){
       this.password = password;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getPassword() {
        return password;
    }

}
