package com.jlinden.todorest;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<Todo, Long> {
}
