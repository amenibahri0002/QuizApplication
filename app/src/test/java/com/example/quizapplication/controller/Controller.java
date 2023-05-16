package com.example.quizapplication.controller;

import com.example.quizapplication.model.Model;
import com.example.quizapplication.view.Question;
import com.example.quizapplication.view.ViewContract;

public class Controller {
    private Model model;
    private ViewContract view;

    public Controller(Model model, ViewContract view) {
        this.model = model;
        this.view = view;
    }

    public void startQuiz() {
        // Display the first question
        Question firstQuestion = model.getCurrentQuestion();
        view.displayQuestion(firstQuestion);
    }

    public void showPreviousQuestion() {
        model.moveToPreviousQuestion();
        Question previousQuestion = model.getCurrentQuestion();
        view.displayQuestion(previousQuestion);
    }

    public void showNextQuestion() {
        model.moveToNextQuestion();
        Question nextQuestion = model.getCurrentQuestion();
        view.displayQuestion(nextQuestion);
    }

    public void submitAnswer() {
        String userAnswer = view.getUserAnswer();
        boolean isCorrect = model.isAnswerCorrect(userAnswer);
        view.displayResult(isCorrect);

        if (model.isQuizFinished()) {
            int score = model.calculateScore();
            view.displayScore(score);

            if (score == 100) {
                view.displayCongratulations();
            }
        }
    }
}
