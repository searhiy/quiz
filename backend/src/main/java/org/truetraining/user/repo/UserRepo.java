package org.truetraining.user.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.truetraining.user.domain.User;

import java.util.List;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    List<User> findByLastName(@Param("name") String name);
}
