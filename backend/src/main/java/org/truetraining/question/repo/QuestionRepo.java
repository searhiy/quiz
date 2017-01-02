package org.truetraining.question.repo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truetraining.question.domain.Question;

import java.util.List;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionRepo extends PagingAndSortingRepository<Question, Long> {

    // http://stackoverflow.com/questions/27387856/how-to-mix-spring-data-repositories-and-spring-rest-controllers
    // https://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html#cache-annotations-cacheable-key
//    @Cacheable(value = "questions_cache", key = "#question")
//    @Cacheable(value = "questions_cache", key = "#question", keyGenerator = )
    @Cacheable(value = "questions_cache")
    List<Question> findByQuestionLike(String question);




}