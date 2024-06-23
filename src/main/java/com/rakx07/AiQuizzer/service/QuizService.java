package com.rakx07.AiQuizzer.service;


import com.rakx07.AiQuizzer.model.Question;
import com.rakx07.AiQuizzer.model.Result;
import com.rakx07.AiQuizzer.repsitory.QuestionRepo;
import com.rakx07.AiQuizzer.repsitory.ResultRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private final QuestionRepo questionRepo;

    private final ResultRepo resultRepo;

    public QuizService(QuestionRepo questionRepo, ResultRepo resultRepo) {
        this.questionRepo = questionRepo;
        this.resultRepo = resultRepo;
    }

    public List<Question> getQuestion() {
        List<Question> allQuestion = questionRepo.findAll();
        List<Question> questionList = new ArrayList<>();

        Random random = new Random();

        for(int i=0; i<5; i++) {
            int randomNumber = random.nextInt(allQuestion.size());
            questionList.add(allQuestion.get(randomNumber));
            allQuestion.remove(randomNumber);
        }

        return questionList;
    }

    public int getResult(List<Question> questionList) {
        int correct = 0;

        for(Question question:questionList) {
            if(question.getAns() == question.getChosen()) {
                correct++;
            }
        }
        return correct;
    }

    public void saveResult(Result result) {
        resultRepo.save(result);
    }

    public List<Result> getTopScore() {
        return resultRepo.findAll(Sort.by(Sort.Direction.DESC,"totalCorrect"));
    }
}
