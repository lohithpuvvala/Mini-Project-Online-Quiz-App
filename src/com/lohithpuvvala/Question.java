package com.lohithpuvvala;

public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    //All Args Contructer
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    //Display Question and Options
    public void displayQuestion(){
        System.out.println(questionText);
        for(int i=0; i<options.length; i++){
            System.out.println((i+1)+". "+options[i]);
        }
    }

    //Validates if userAnswer is Correct/Incorrect
    public boolean isCorrectAnswer(int userAnswer){
        return userAnswer == correctAnswerIndex + 1;
    }
}
