package local.barge.todos.services;

import local.barge.todos.models.User;

import java.util.List;

public interface UserService
{

    List<User> findAll();


    List<User> findByNameContaining(String username);


    User findUserById(long id);


    User findByName(String name);


    void delete(long id);


    User save(User user);


    User update(
        User user,
        long id);

    void deleteUserTodo(long userid, long todoid);

    void addUserTodo(long userid, long todoid);
}