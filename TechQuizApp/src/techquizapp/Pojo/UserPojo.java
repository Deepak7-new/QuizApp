
package techquizapp.Pojo;

public class UserPojo {
    private String userid;
    private String password;
    private String userType;

    public UserPojo(String userid, String password, String userType) {
        this.userid = userid;
        this.password = password;
        this.userType = userType;
    }

    public UserPojo() {
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
}
