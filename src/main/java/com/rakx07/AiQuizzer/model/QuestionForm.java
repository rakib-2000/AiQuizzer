package com.rakx07.AiQuizzer.model;

import lombok.Getter;

import java.util.List;
@Getter
public class QuestionForm {
    private List<Question> questions;

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
