package org.truetraining.question.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String answer;
    private boolean isRight;
}
