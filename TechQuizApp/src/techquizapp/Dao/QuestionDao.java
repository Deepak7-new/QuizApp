
package techquizapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.Dbutil.DBConnection;
import techquizapp.Pojo.QuestionPojo;
import techquizapp.Pojo.QuestionStore;

public class QuestionDao {
    public static void addQuestion(QuestionStore qstore) throws SQLException {
        String qry = "Insert into questions values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<QuestionPojo> questionList = qstore.getAllQuestions();
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        for(QuestionPojo obj : questionList){
           ps.setString(1, obj.getExamId());
           ps.setInt(2, obj.getQno());
           ps.setString(3, obj.getQuestion());
           ps.setString(4, obj.getAnswer1());
           ps.setString(5, obj.getAnswer2());
           ps.setString(6, obj.getAnswer3());
           ps.setString(7, obj.getAnswer4());
           ps.setString(8, obj.getCorrectAnswer());
           ps.setString(9, obj.getLanguage());
           ps.executeUpdate();
        }
    }

    public static ArrayList<QuestionPojo> getQuestionsByExamId(String examId) throws SQLException {
        String qry = "Select * from questions where examid = ? order by qno";
        ArrayList<QuestionPojo> questionList = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn. prepareStatement(qry);
        ps.setString(1, examId);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            int qno = rs.getInt(2);
            String question = rs.getString(3);
            String option1 = rs.getString(4);
            String option2 = rs.getString(5);
            String option3 = rs.getString(6);
            String option4 = rs.getString(7);
            String correctAnswer = rs.getString(8);
            String language = rs.getString(9);
            QuestionPojo obj = new QuestionPojo(examId, qno, language, option1, option2, option3, option4, correctAnswer, question);
            questionList.add(obj);
        }
        return questionList;
    }
    
    public static void updateQuestion(QuestionPojo pjo, String examId, int qno) throws SQLException{
        String qry = "update questions set question = ?, answer1 = ?, answer2 = ?, answer3 = ?, answer4 = ?, correct_answer = ? where examid = ? and qno = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, pjo.getQuestion());
        ps.setString(2, pjo.getAnswer1());
        ps.setString(3, pjo.getAnswer2());
        ps.setString(4, pjo.getAnswer3());
        ps.setString(5, pjo.getAnswer4());
        ps.setString(6, pjo.getCorrectAnswer());
        ps.setString(7, pjo.getExamId());
        ps.setInt(8, pjo.getQno());
        ps.executeUpdate();
    }
}
