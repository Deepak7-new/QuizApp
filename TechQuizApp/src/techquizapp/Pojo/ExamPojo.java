
package techquizapp.Pojo;


public class ExamPojo {
    private String ExamId;
    private String language;
    private int totalQuestions;

    public ExamPojo() {
    }

    public ExamPojo(String ExamId, String language, int totalQuestions) {
        this.ExamId = ExamId;
        this.language = language;
        this.totalQuestions = totalQuestions;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getExamId() {
        return ExamId;
    }

    public String getLanguage() {
        return language;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    @Override
    public String toString() {
        return "ExamPojo{" + "ExamId=" + ExamId + ", language=" + language + ", totalQuestions=" + totalQuestions + '}';
    }
    
}
