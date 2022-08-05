package com.example.quiz;

public class Quiz {
    String question;
    Boolean answer;


    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Quiz(String question, Boolean answer) {
        this.question = question;
        this.answer = answer;
    }


}
