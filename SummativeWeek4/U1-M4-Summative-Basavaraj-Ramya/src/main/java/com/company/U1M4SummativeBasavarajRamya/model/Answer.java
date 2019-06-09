package com.company.U1M4SummativeBasavarajRamya.model;

import javax.validation.constraints.NotEmpty;

/**
 * Answer object
 */
public class Answer {
    @NotEmpty(message = "You must enter a question to get Magic 8-Answer")
    private String question;
    private String answer;

    public Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public Answer(String answer){
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
