package local.barge.todos.services;

import local.barge.todos.models.Todos;
import local.barge.todos.models.User;
import local.barge.todos.repository.UserRepository;
import local.barge.todos.views.TodosCompleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userrepos;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) throws EntityNotFoundException {
        return userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found"));
    }

    @Transactional
    @Override
    public User save(User user) {

        User newUser = new User();

        if (user.getUserid() != 0) {
            newUser.setUserid(user.getUserid());
        }

        newUser.setUsername(user.getUsername()
                .toLowerCase());
        newUser.setPassword(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail()
                .toLowerCase());

        for (Todos t : user.getTodos()) {
            newUser.getTodos().add(new Todos(newUser, t.getDescription()));
        }

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
        userrepos.deleteById(id);
    }

    @Override
    public List<TodosCompleted> getTodosCompleted() {
        return userrepos.getTodosCompleted();
    }
}
