package org.truetraining.util;

import org.springframework.stereotype.Component;
import org.truetraining.question.domain.Answer;
import org.truetraining.question.domain.Question;
import org.truetraining.question.repo.QuestionRepo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Component
public class QuestionsGenerator {

    private QuestionRepo questionRepo;

    public QuestionsGenerator(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @PostConstruct
    public void generateQuestions() {

        List<Question> questions = new ArrayList<>();

        Stream<Question> randomQuestions = Stream.generate(
                () -> Question.builder()
                        .question("question" + UUID.randomUUID())
                        .answers(
                                Stream.generate(() -> Answer.builder().answer("answer" + UUID.randomUUID()).build())
                                        .limit(10).sorted().collect(Collectors.toSet()))
                        .build()
        );
        randomQuestions.limit(1_000).sorted().forEach(questions::add);

        questionRepo.save(questions);
    }
}
