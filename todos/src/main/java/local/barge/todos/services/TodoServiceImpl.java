package local.barge.todos.services;

import local.barge.todos.models.Todos;
import local.barge.todos.repository.TodoRepository;
import local.barge.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public Todos addTodo(long userid, String desc) {
        Todos newTodo = new Todos();
        newTodo.setUser(userrepos.findById(userid)
                .orElseThrow(() -> new EntityNotFoundException("User with " + userid + " not found :(")));
        newTodo.setDescription(desc);

        return todorepos.save(newTodo);
    }

    @Override
    public Todos markCompleted(long todoid) {
        Todos newTodo = todorepos.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Could not find todo " + todoid));
        newTodo.setCompleted(true);

        return todorepos.save(newTodo);
    }
}
