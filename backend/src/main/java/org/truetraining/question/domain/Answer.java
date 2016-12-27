package org.truetraining.question.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANSWER")
public class Answer implements Comparable<Answer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String answer;
    private boolean isRight;

    @Override
    public int compareTo(Answer answer) {
        return this.answer.compareTo(answer.getAnswer());
    }
}
