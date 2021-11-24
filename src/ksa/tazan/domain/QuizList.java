package ksa.tazan.domain;

import java.util.ArrayList;

public class QuizList {
    private static ArrayList<Quiz> quizList=new ArrayList<>();

    public static void addQuiz(Quiz quiz){
        quizList.add(quiz);
    }

    public static ArrayList<Quiz> getQuizList(){
        return quizList;
    }
}
