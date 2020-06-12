package local.barge.todos.repository;

import local.barge.todos.models.User;
import local.barge.todos.views.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The CRUD repository connecting User to the rest of the application
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    /**
     * Find a user based off over username
     *
     * @param username the name (String) of user you seek
     * @return the first user object with the name you seek
     */
    User findByUsername(String username);

    /**
     * Find all users whose name contains a given substring ignoring case
     *
     * @param name the substring of the names (String) you seek
     * @return List of users whose name contain the given substring ignoring case
     */
    List<User> findByUsernameContainingIgnoreCase(String name);

    @Query(value = "SELECT COUNT(*) as count FROM usertodos WHERE userid = :userid AND todoid = :todoid", nativeQuery = true)
    JustTheCount checkUserTodosCompleted(long userid, long todoid);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM usertodos WHERE userid = :userid AND todoid = :todoid", nativeQuery = true)
    void deleteUserRoles(long userid, long todoid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usertodos(userid, todoid, created_by, created_date, last_modified_by, last_modified_date) VALUES (:userid, :todoid, :uname, CURRENT_TIMESTAMP, :uname, CURRENT_TIMESTAMP)",
            nativeQuery = true)
    void insertUserRoles(
            String uname,
            long userid,
            long todoid);

}
