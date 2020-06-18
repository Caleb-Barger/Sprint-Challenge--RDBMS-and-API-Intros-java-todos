package local.barge.todos.services;

import local.barge.todos.models.User;
import local.barge.todos.views.TodosCompleted;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    User save(User user);

    void delete(long id);

    List<TodosCompleted> getTodosCompleted();
}
