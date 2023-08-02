package com.jlinden.todorest.service;

import com.jlinden.todorest.model.Todo;
import com.jlinden.todorest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Todo> findById(Long id) {
        return repository.findById(id);
    }

}
