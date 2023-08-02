import { TodoItem } from "./TodoItem";

export function TodoList({ todos, updateTodo, deleteTodo }) {
  return (
    <ul className="list">
      {todos.length === 0 && "No Todos"}
      {todos.map((todo) => {
        return (
          <TodoItem
            {...todo}
            key={todo.id}
            updateTodo={updateTodo}
            deleteTodo={deleteTodo}
          />
        );
      })}
    </ul>
  );
}
