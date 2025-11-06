package com.tasksApp.demo.Controllers;

import com.tasksApp.demo.Entity.Task;
import com.tasksApp.demo.Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class TasksAPIController {

    //Inves de injetar via construtor podemos utilizar a anotação @Autowired.
    @Autowired // Cria e injeta um componente automaticamente em execução.
    private TasksService tasksService;

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/tasks")
    public List<Task> getTaskList(){
        return tasksService.getAllTasks();
    }
    //GET /app/tasks/id
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return tasksService.getTaskById(id);
    }
    // POST /app/tasks
    @PostMapping("/tasks")
    public String createTask(@RequestBody Task task){
        tasksService.createTask(task);
        return "Tarefa salva com sucesso";
    }
    // PUT /app/tasks/{id}
//    @PutMapping("/tasks/{id}")
//    public void updateTask(@PathVariable int id, @RequestBody Task task){
//    }
    // DELETE /app/tasks/{id}
    @DeleteMapping("/tasks/{id}")
    public void createTask(@PathVariable int id){
        tasksService.deleteTask(id);
    }
}
