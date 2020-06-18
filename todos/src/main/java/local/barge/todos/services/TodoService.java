package local.barge.todos.services;

import local.barge.todos.models.Todos;

public interface TodoService {

    Todos addTodo(long userid, String desc);

    Todos markCompleted(long todoid);
}
