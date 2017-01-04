package toyStore.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

    List<User> findByEmployeeEmail(String email);


}


