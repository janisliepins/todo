package com.jlinden.todorest;

import jakarta.persistence.*;

import java.util.Objects;

@Entity // This tells Hibernate to make a table out of this class
class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private Boolean isCompleted = false;

    Todo() {}

    Todo(String title, Boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(title, todo.title) && Objects.equals(isCompleted, todo.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
