package org.truetraining.question;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.truetraining.question.domain.Question;
import org.truetraining.question.repo.QuestionRepo;

import java.util.List;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@RestController
public class Controller {

    private QuestionRepo questionRepo;

    public Controller(QuestionRepo questionRepo){
        this.questionRepo = questionRepo;
    }

    @GetMapping(value = "/cache")
    public ResponseEntity<List<Question>> returnRangeBusinessCalendar() {
        List<Question> rangeBusinessCalendar = questionRepo.findByQuestionLike("question%");
        return ResponseEntity.ok(rangeBusinessCalendar);
    }
}
