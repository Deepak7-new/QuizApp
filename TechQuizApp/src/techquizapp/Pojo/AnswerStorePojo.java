
package techquizapp.Pojo;

import java.util.ArrayList;

public class AnswerStorePojo {
    ArrayList<AnswerPojo> answerList;
    
    public AnswerStorePojo(){
        answerList = new ArrayList<>();
    }
    public void addAnswer(AnswerPojo answer){
        answerList.add(answer);
    }
    public AnswerPojo getAnswer(int pos){
        return answerList.get(pos);
    }
    public void removeAnswer(int pos){
        answerList.remove(pos);
    }
    public void setAnswerAt(int pos, AnswerPojo answer){
        answerList.add(pos, answer);
    }
    public ArrayList<AnswerPojo> getAllAnswer(){
        return answerList;
    }
    public int getCount(){
        return answerList.size();
    }
    public AnswerPojo getAnswerByQno(int qno){
        for(AnswerPojo answer : answerList){
            if(answer.getQno() == qno)
                return answer;
        }
        return null;
    }
    public int removeAnswer(AnswerPojo answer){
        int pos = answerList.indexOf(answer);
        answerList.remove(pos);
        return pos;
    }
}
