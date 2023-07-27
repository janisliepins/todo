package com.jlinden.todorest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class TodoController {
    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/todos")
    List<Todo> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/todos")
    Todo newTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    // Single item
    @GetMapping("/todos/{id}")
    Todo one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todos/{id}")
    Todo replaceTodo(@RequestBody Todo newTodo, @PathVariable Long id) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(newTodo.getTitle());
                    todo.setCompleted(newTodo.getCompleted());
                    return repository.save(todo);
                })
                .orElseGet(() -> {
                    newTodo.setId(id);
                    return repository.save(newTodo);
                });
    }

    @DeleteMapping("/todos/{id}")
    void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
