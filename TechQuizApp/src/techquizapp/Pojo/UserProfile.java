
package techquizapp.Pojo;

public class UserProfile {
    private static String username;     //because only one user will use this app at a time
    private static String usertype;

    public static String getUsername() {
        return username;
    }

    public static String getUsertype() {
        return usertype;
    }

    public static void setUsername(String username) {
        UserProfile.username = username;
    }

    public static void setUsertype(String usertype) {
        UserProfile.usertype = usertype;
    }
    
}
