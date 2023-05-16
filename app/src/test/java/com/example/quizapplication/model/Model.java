package com.example.quizapplication.model;

import com.example.quizapplication.view.Question;

import java.util.List;

public class Model {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public Model(List<Question> questions) {
        this.questions = questions;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void moveToNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        }
    }

    public void moveToPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
        }
    }

    public boolean isAnswerCorrect(String answer) {
        boolean isCorrect = getCurrentQuestion().getAnswer().equals(answer);
        if (isCorrect) {
            score++; // Increment the score if the answer is correct
        }
        return isCorrect;
    }

    public int getScore() {
        return score;
    }

    public int calculateScore() {
        int totalQuestions = questions.size();
        return (score * 100) / totalQuestions;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex >= questions.size() - 1;
    }
}
