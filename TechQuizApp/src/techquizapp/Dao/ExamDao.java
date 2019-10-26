package techquizapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import techquizapp.Dbutil.DBConnection;
import techquizapp.Pojo.ExamPojo;

public class ExamDao {

    public static String getExamId() throws SQLException {
        String qry = "Select count(*) as totalrows from Exam";      //ans of count will be in variable totalrows sql function count(*) return no of rows[* = can pass column no]
        int rowCount = 0;
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        if (rs.next()) {
            rowCount = rs.getInt(1);    //((we can also write totalrows here instead of 1)here we are getting a column of integers contaning one row (total rows in exam)
        }
        String newId = "EX- " + (rowCount + 1);
        return newId;
    }

    public static boolean addExam(ExamPojo newExam) throws SQLException {
        String qry = " Insert into Exam values(?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, newExam.getExamId());
        ps.setString(2, newExam.getLanguage());
        ps.setInt(3, newExam.getTotalQuestions());
        int ans = ps.executeUpdate();
        return ans == 1;
    }

    public static boolean isPaperSet(String subject) throws SQLException {
        String qry = "Select examid from Exam where language = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, subject);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public static ArrayList<String> getExamIdBySubject(String userid, String subject) throws SQLException {

        // String qry = "Select examid from exam where language = ? minus select examid from performance where userid = ?";
        String qry1 = "Select examid from exam where language = ?";

        ArrayList<String> examList = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry1);
        ps.setString(1, subject);
        ResultSet rs = ps.executeQuery();

        String qry2 = "select examid from performance where userid = '" + userid + "'";
        PreparedStatement ps2 = conn.prepareStatement(qry2);
        // ps.setString(1, userid);
        ResultSet rs2 = ps2.executeQuery();

        System.out.println(rs2.next());

        while (rs.next()) {
            if (rs2.next()) {
                if (!(rs.getString(1).equalsIgnoreCase(rs2.getString(1)))) {
                    examList.add(rs.getString(1));
                }
            } else {
                examList.add(rs.getString(1));
            }

        }

        /* while(rs.next()){
            examList.add(rs.getString(1));
        }*/
        return examList;
    }

    public static int getQuestionCountByExam(String examid) throws SQLException {
        String qry = "Select total_question from exam where examid = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, examid);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int rowCount = rs.getInt(1);
        return rowCount;
    }
}
