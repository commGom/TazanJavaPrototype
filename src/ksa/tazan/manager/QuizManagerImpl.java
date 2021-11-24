package ksa.tazan.manager;

import ksa.tazan.domain.Quiz;

import java.util.ArrayList;

public class QuizManagerImpl implements QuizManager{
    @Override
    public ArrayList<Quiz> sendQuiz() {
        return null;
    }

    @Override
    public ArrayList<Quiz> sendQuiz(int count) {
        return null;
    }

    @Override
    public boolean solveQuiz(String myAnswer, Quiz quiz) {
        if (myAnswer.equals(quiz.getAnswer())){
            return true;
        }
        return false;
    }

    @Override
    public int markQuestions() {
        return 0;
    }

    @Override
    public ArrayList<Quiz> sendWrongQuiz() {
        return null;
    }
}
