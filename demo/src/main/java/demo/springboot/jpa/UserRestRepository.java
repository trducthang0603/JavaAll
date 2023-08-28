package demo.springboot.jpa;
import java.util.List;

import demo.springboot.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRestRepository extends
        PagingAndSortingRepository<User, Long> {
    List<User> findByRole(@Param("role") String role);
}
