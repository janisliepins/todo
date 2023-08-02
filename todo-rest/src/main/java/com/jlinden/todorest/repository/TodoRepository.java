package com.jlinden.todorest.repository;

import com.jlinden.todorest.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
