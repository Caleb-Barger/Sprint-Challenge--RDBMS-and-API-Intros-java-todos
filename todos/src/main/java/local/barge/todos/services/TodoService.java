package local.barge.todos.services;

import local.barge.todos.models.Todo;

import java.util.List;

/**
 * The Service that works with the Todo Model
 * <p>
 * Note: Emails are added through the add user process
 */
public interface TodoService
{

    List<Todo> findAll();

    Todo findUseremailById(long id);

    void delete(long id);

    Todo update(
        long useremailid,
        String emailaddress);

    Todo save(
        long userid,
        String emailaddress);
}
