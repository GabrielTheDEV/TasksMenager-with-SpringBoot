package com.tasksApp.demo.Controllers;

import com.tasksApp.demo.Entity.Task;
import com.tasksApp.demo.Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    // Obter tarefas
    @GetMapping("/tasks")
    public List<Task> getTasksList(@RequestParam(required = false) Boolean completed){
        if (completed == null) {
            return tasksService.getAllTasks();
        }
        return completed
                ? tasksService.getTasksCompleted()      // Para filtrar por tarefas completas
                : tasksService.getTasksIncomplete();
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
    //PUT /app/tasks/{id}
    @PutMapping("/tasks/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task){
        tasksService.changeDescription(id,task);
    }
    @PatchMapping("/tasks/{id}/completed")
    public void markAsCompleted(@PathVariable int id){
        Task task = tasksService.markAsCompleted(id);
    }

    @PatchMapping("/tasks/{id}/incomplete")
    public void markAsIncomplete(@PathVariable int id){
        Task task = tasksService.markAsIncomplete(id);
    }

    // DELETE /app/tasks/{id}
    @DeleteMapping("/tasks/{id}")
    public void createTask(@PathVariable int id){
        tasksService.deleteTask(id);
    }
}
