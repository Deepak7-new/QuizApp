
package techquizapp.Pojo;

public class StudentScorePojo {
    private String language;
    private double per;

    public String getLanguage() {
        return language;
    }

    public double getPer() {
        return per;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public StudentScorePojo(String language, double per) {
        this.language = language;
        this.per = per;
    }

    public StudentScorePojo() {
    }
}
