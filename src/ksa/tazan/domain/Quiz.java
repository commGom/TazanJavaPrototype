package ksa.tazan.domain;

public class Quiz {
    private int quizNo;
    private String question;
    private String answer;

    public Quiz() {
    }

    public Quiz(int quizNo, String question, String answer) {
        this.quizNo = quizNo;
        this.question = question;
        this.answer = answer;
    }

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizNo=" + quizNo +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
