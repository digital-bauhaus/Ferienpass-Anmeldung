package de.jonashackt.ferienpassanmeldung.repository;


import de.jonashackt.ferienpassanmeldung.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value="FROM User")
    List<User> findAllUsers();

    List<User> findByLastName(@Param("lastname") String lastname);

    List<User> findByFirstName(@Param("firstname") String firstname);
}
