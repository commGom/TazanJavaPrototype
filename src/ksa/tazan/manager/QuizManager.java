package ksa.tazan.manager;

import ksa.tazan.domain.Quiz;

import java.util.ArrayList;

public interface QuizManager {
    ArrayList<Quiz> sendQuiz();
    ArrayList<Quiz> sendQuiz(int count);    //풀 문제 갯수 선택가능하도록 overloading
    boolean solveQuiz(String myAnswer, Quiz quiz);  //내가 쓴 답과 Quiz 해답과 비교하여 true false로 반환
    int markQuestions();   //출제된 문제  for문 돌면서 맞은 갯수 count하고 틀린 문제 오답문제리스트에 담
    ArrayList<Quiz> sendWrongQuiz();

}
