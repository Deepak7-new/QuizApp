
package techquizapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.Dbutil.DBConnection;
import techquizapp.Pojo.UserPojo;

public class UserDao {
    public static boolean validateUser(UserPojo user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where userid = ? and password = ? and usertype = ?");
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static boolean addUser(UserPojo user) throws SQLException{
        String qry = "select * from users where userid = ?";
        boolean status = true;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, user.getUserid());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            status = false;
        else {
            qry = "Insert into users values(?, ?, ?)";
            ps = conn.prepareStatement(qry);
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserType());
            ps.executeUpdate();
        }
        return status;
    }
    public static int changePassword(String password, String userid)throws SQLException {
        String qry = "update users set password = ? where userid = ? ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, password);
        ps.setString(2,userid);
        return ps.executeUpdate(); 
    }
}
