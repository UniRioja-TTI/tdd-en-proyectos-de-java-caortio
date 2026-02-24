package mock;

import java.util.List;

import com.tt1.test.ToDo;

public interface Database 
{
    // CRUD para las tareas (ToDos)
    void addTask(ToDo task);
    void removeTask(ToDo task);
    List<ToDo> getAllTasks();
    ToDo getTaskByName(String name);

    // CRUD para los correos electrónicos
    void addEmail(String email);
    void removeEmail(String email);
    List<String> getEmailAgenda();
}
