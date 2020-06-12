package local.barge.todos;

import local.barge.todos.models.User;
import local.barge.todos.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {
        User u1 = new User("admin",
            "password",
            "admin@lambdaschool.local");
        u1.getTodos()
            .add(new Todo(u1,
                "Give Joe access rights"));
        u1.getTodos()
            .add(new Todo(u1,
                "Change the color of the home page"));

        userService.save(u1);

        User u2 = new User("cinnamon",
            "1234567",
            "cinnamon@lambdaschool.local");
        u2.getTodos()
            .add(new Todo(u2,
                "Take a nap"));
        u2.getTodos()
            .add(new Todo(u2,
                "Rearrange my hutch"));
        u2.getTodos()
            .add(new Todo(u2,
                "Groom my fur"));
        userService.save(u2);

        User u3 = new User("barnbarn",
            "ILuvM4th!",
            "barnbarn@lambdaschool.local");
        u3.getTodos()
            .add(new Todo(u3,
                "Rearrange my hutch"));
        userService.save(u3);

        User u4 = new User("puttat",
            "password",
            "puttat@school.lambda");
        userService.save(u4);

        User u5 = new User("misskitty",
            "password",
            "misskitty@school.lambda");
        userService.save(u5);
    }
}
