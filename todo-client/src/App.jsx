import { useEffect, useState } from "react";
import { TodoList } from "./components/TodoList";
import { TodoForm } from "./components/TodoForm";
import axios from "axios";

import "./styles.css";

export default function App() {
  const [todos, setTodos] = useState([]);

  const fetchTodos = async () => {
    const response = await axios.get("/todos");
    setTodos(response.data);
  };

  useEffect(() => {
    fetchTodos();
  }, []);

  const createTodo = async (newTodoTitle) => {
    const response = await axios.post("/todos", {
      title: newTodoTitle,
    });

    setTodos([...todos, response.data]);
  };

  const deleteTodo = async (id) => {
    await axios.delete(`/todos/${id}`);
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  const updateTodo = async (id, isCompleted) => {
    const todo = todos.find((todo) => todo.id === id);
    const updatedTodo = { ...todo, isCompleted };

    await axios.put(`/todos/${id}`, updatedTodo);

    setTodos((currentTodos) => {
      return currentTodos.map((todo) => {
        if (todo.id === id) {
          return { ...todo, isCompleted };
        }
        return todo;
      });
    });
  };

  return (
    <>
      <TodoForm onSubmit={createTodo} />
      <h1 className="header">Todo List</h1>
      <TodoList todos={todos} updateTodo={updateTodo} deleteTodo={deleteTodo} />
    </>
  );
}
