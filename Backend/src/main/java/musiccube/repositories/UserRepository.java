package musiccube.repositories;

import musiccube.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u from User u where u.id = ?1")
    Optional<User> findById(int id);

    @Query("SELECT u from User u WHERE LOWER(u.userName) LIKE LOWER(CONCAT('%',?1,'%'))")
    Iterable<User> findByUserName(String userName);


    Optional<User> findOneByUserName(String userName);

    @Query("select password from User u where u.userName like ?1")
    String findPasswordByUserName(String userName);

    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);


}
