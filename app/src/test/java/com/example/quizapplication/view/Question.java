package com.example.quizapplication.view;

public class Question {
    private final String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getOption1() {
        return 0;
    }

    public int getOption2() {
        return 0;
    }

    public int getOption3() {
        return 0;
    }

    public int getOption4() {
        return 0;
    }
}
