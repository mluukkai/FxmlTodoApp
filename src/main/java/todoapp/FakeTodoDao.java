package todoapp;

import java.util.ArrayList;
import java.util.List;
import todoapp.dao.TodoDao;
import todoapp.domain.Todo;

public class FakeTodoDao implements TodoDao {
    List<Todo> todos;

    public FakeTodoDao() {
        todos = new ArrayList<>();
    }   
   
    @Override
    public List<Todo> getAll() {
        return todos;
    }
    
    @Override
    public Todo create(Todo todo) throws Exception {
        todo.setId(todos.size()+1);
        todos.add(todo);
        return todo;
    }   
    
    @Override
    public void setDone(int id) {
        for (Todo t : todos) {
            if ( t.getId()==id) {
                t.setDone();
            }
        }
    }   

}
