package local.barge.todos.controllers;

import local.barge.todos.models.Todos;
import local.barge.todos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping(value = "/user/{userid}", consumes = {"application/json"})
    public ResponseEntity<?> addNewTodo(@RequestBody String desc, @PathVariable Long userid) throws URISyntaxException {
        Todos newTodo = todoService.addTodo(userid, desc);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTodoURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newTodo.getTodoid())
                .toUri();
        responseHeaders.setLocation(newTodoURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    @PatchMapping(value = "/todos/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> markCompeted(@PathVariable long todoid) {
        Todos newTodo = todoService.markCompleted(todoid);
        return new ResponseEntity<>(newTodo, HttpStatus.OK);
    }

}
