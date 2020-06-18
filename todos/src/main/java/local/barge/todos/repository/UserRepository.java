package local.barge.todos.repository;

import local.barge.todos.models.User;
import local.barge.todos.views.TodosCompleted;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {


    @Query(value = "SELECT u.username as usernamerpt, count(t.todoid) as counttodos FROM users u JOIN todos t ON u.userid = t.userid WHERE NOT t.completed GROUP BY u.username",
            nativeQuery = true)
    List<TodosCompleted> getTodosCompleted();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users(userid, roleid, created_by, created_date, last_modified_by, last_modified_date) VALUES (:userid, :roleid, :uname, CURRENT_TIMESTAMP, :uname, CURRENT_TIMESTAMP)",
            nativeQuery = true)
    void insertUserRoles(
            String uname,
            long userid,
            long roleid);
}
