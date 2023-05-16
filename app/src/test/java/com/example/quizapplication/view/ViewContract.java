package com.example.quizapplication.view;

import android.view.View;

public interface ViewContract {

        default void displayQuestion(Question question) {

        }

        void displayResult(boolean isCorrect);
        void displayScore(int score);
        void displayCongratulations();
        String getUserAnswer();
        void setOnPreviousClickListener(View.OnClickListener listener);
        void setOnSubmitClickListener(View.OnClickListener listener);
        void setOnNextClickListener(View.OnClickListener listener);
}
