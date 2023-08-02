package com.jlinden.todorest.controller;

import com.jlinden.todorest.model.Todo;
import com.jlinden.todorest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // This would allow all origins
@RestController
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<Todo> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/todos")
    Todo newTodo(@RequestBody Todo newTodo) {
        return service.save(newTodo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getOne(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo newTodo) {
        return service.findById(id)
                .map(todo -> {
                    todo.setTitle(newTodo.getTitle());
                    todo.setIsCompleted(newTodo.getIsCompleted());
                    return ResponseEntity.ok(service.save(todo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
