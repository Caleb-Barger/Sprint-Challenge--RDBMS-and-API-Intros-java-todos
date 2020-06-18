package local.barge.todos.repository;

import local.barge.todos.models.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todos, Long> {
}
