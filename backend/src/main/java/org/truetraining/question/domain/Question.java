package org.truetraining.question.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    @ElementCollection
    @CollectionTable(name="answers", joinColumns=@JoinColumn(name="question_id"))
    private Set<Answer> answers;
}
