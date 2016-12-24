package org.truetraining.question.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truetraining.question.domain.Question;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@RepositoryRestResource(collectionResourceRel = "question", path = "questions")
public interface QuestionRepo extends PagingAndSortingRepository<Question, Long> {

}