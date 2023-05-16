package com.example.quizapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.model.Model;
import com.example.quizapplication.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public  class MainActivity extends AppCompatActivity implements ViewContract {

        private List<Question> questionList;
        private int currentQuestionIndex = 0;
        private int correctAnswers = 0;

        private TextView tvQuestion;
        private RadioGroup radioGroup;
        private RadioButton radioOption1, radioOption2, radioOption3, radioOption4;
        private Button btnSubmit, btnPrevious;
        private TextView tvScore;
        private TextView tvCongratulations;

        private Controller controller;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main_activity);
                setContentView(R.layout.main_activity2);
                setContentView(R.layout.main_activity3);

                // Initialize views
                tvScore = findViewById(R.id.tv_score);
                tvCongratulations = findViewById(R.id.tv_congratulations);
                tvQuestion = findViewById(R.id.tv_question);
                radioGroup = findViewById(R.id.radio_group);
                radioOption1 = findViewById(R.id.radio_option_1);
                radioOption2 = findViewById(R.id.radio_option_2);
                radioOption3 = findViewById(R.id.radio_option_3);
                radioOption4 = findViewById(R.id.radio_option_4);
                btnSubmit = findViewById(R.id.btn_submit);
                btnPrevious = findViewById(R.id.btn_previous);

                // Create question list
                questionList = new ArrayList<>();
                questionList.add(new Question("Quelle est la capitale de la Tunisie ?", "Tunis"));
                questionList.add(new Question("Quel est la monnaie de la Tunisie ?", "Dinar tunisien"));
                questionList.add(new Question("Quel est le plat national de la Tunisie ?", "Couscous"));

                // Create model and controller
                Model model = new Model(questionList);
                controller = new Controller(model, this);

                // Set up button listeners
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Get selected radio button
                                int selectedId = radioGroup.getCheckedRadioButtonId();
                                RadioButton selectedRadioButton = findViewById(selectedId);

                                // Check if answer is selected
                                if (selectedRadioButton != null) {
                                        String selectedAnswer = selectedRadioButton.getText().toString();
                                        String correctAnswer = questionList.get(currentQuestionIndex).getAnswer();
                                        if (selectedAnswer.equals(correctAnswer)) {
                                                correctAnswers++;
                                        }
                                }

                                // Move to the next question
                                controller.showNextQuestion();
                        }
                });

                btnPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Move to the previous question
                                controller.showPreviousQuestion();
                        }
                });

                // Start the quiz
                controller.startQuiz();
        }

        @Override
        public void displayQuestion(Question question) {
                // Set the question text
                tvQuestion.setText(question.getQuestion());

                // Set the answer options
                radioOption1.setText(question.getOption1());
                radioOption2.setText(question.getOption2());
                radioOption3.setText(question.getOption3());
                radioOption4.setText(question.getOption4());
        }

        @Override
        public void displayResult(boolean isCorrect) {
                // Display the result (e.g., show a toast, update UI)
        }

        @Override
        public void displayScore(int score) {
                // Display the score (e.g., show a toast, update UI)
        }

        @Override
        public void displayCongratulations() {
                // Display congratulations message (e.g., show a toast, update UI)
        }

        @Override
        public String getUserAnswer() {
                // Retrieve the selected answer from the radio group and return it
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if (selectedRadioButton != null) {
                        return selectedRadioButton.getText().toString();
                }
                return null;
        }

        @Override
        public void setOnPreviousClickListener(View.OnClickListener listener) {
                // Set the click listener for the previous button
                btnPrevious.setOnClickListener(listener);
        }

        @Override
        public void setOnSubmitClickListener(View.OnClickListener listener) {
                // Set the click listener for the submit button
                btnSubmit.setOnClickListener(listener);
        }

        @Override
        public void setOnNextClickListener(View.OnClickListener listener) {
                // Set the click listener for the next button
                // This method is missing in the provided code, add it to your ViewContract interface
        }


}



