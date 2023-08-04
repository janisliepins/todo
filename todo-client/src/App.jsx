import { useEffect, useState } from "react";
import { TodoList } from "./components/TodoList";
import { TodoForm } from "./components/TodoForm";
import axios from "axios";

import "./styles.css";

export default function App() {
  const [todos, setTodos] = useState([]);

  const fetchTodos = async () => {
    const response = await axiosInstance.get("/todos");
    setTodos(response.data);
  };

  useEffect(() => {
    fetchTodos();
  }, [todos]);

  const createTodo = async (newTodoTitle) => {
    const response = await axiosInstance.post("/todos", {
      title: newTodoTitle,
    });

    setTodos([...todos, response.data]);
  };

  const deleteTodo = async (id) => {
    await axiosInstance.delete(`/todos/${id}`);
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  const updateTodo = async (id, isCompleted) => {
    const todo = todos.find((todo) => todo.id === id);
    const updatedTodo = { ...todo, isCompleted };

    await axiosInstance.put(`/todos/${id}`, updatedTodo);

    setTodos((currentTodos) => {
      return currentTodos.map((todo) => {
        if (todo.id === id) {
          return { ...todo, isCompleted };
        }
        return todo;
      });
    });
  };

  const axiosInstance = axios.create({
    baseURL: import.meta.env.VITE_REST_URL || "http://localhost:8081",
  });

  return (
    <>
      <TodoForm onSubmit={createTodo} />
      <h1 className="header">Todo List</h1>
      <TodoList todos={todos} updateTodo={updateTodo} deleteTodo={deleteTodo} />
    </>
  );
}
