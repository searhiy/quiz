package org.truetraining.question.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUESTION")
public class Question implements Comparable<Question>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Answer> answers;

    @Override
    public int compareTo(Question question) {
        return this.question.compareTo(question.getQuestion());
    }
}
