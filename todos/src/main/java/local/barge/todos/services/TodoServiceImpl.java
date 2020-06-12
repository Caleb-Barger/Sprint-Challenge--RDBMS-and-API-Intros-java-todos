package local.barge.todos.services;

import local.barge.todos.models.User;
import local.barge.todos.models.Todo;
import local.barge.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the UseremailService Interface
 */
@Transactional
@Service(value = "useremailService")
public class TodoServiceImpl implements TodoService
{
    /**
     * Connects this service to the Todo model
     */
    @Autowired
    private TodoRepository todorepos;

    /**
     * Connects this servive to the User Service
     */
    @Autowired
    private UserService userService;

    @Override
    public List<Todo> findAll()
    {
        List<Todo> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        todorepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Todo findTodoById(long id)
    {
        return todorepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (todorepos.findById(id)
            .isPresent())
        {
            todorepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Todo with id " + id + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Todo update(
        long todoid,
        String description)
    {
        if (todorepos.findById(todoid)
            .isPresent())
        {
            Todo todo = findTodoById(todoid);
            todo.setDescription(description.toLowerCase());
            return todorepos.save(todo);
        } else
        {
            throw new EntityNotFoundException("Todo with id " + todoid + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Todo save(
        long userid,
        String description)
    {
        User currentUser = userService.findUserById(userid);

        Todo newTodo = new Todo(currentUser,
                description);
        return todorepos.save(newTodo);
    }
}
