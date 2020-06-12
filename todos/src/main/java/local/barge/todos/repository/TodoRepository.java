package local.barge.todos.repository;

import local.barge.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD Repository connecting Useremail to the rest of the application
 */
public interface TodoRepository extends CrudRepository<Todo, Long>
{
}
