package com.tasksApp.demo.Services;

import com.tasksApp.demo.Entity.Task;
import com.tasksApp.demo.Repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    // Injetando a interface Repository para comunicação com o banco de dados. Através do construtor.
    public TasksService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }


    public List<Task> getAllTasks(){
        return tasksRepository.findAll();
    }
    public Task getTaskById(int id){
        return tasksRepository.findById(id).orElseThrow();
    }
    public void createTask(Task task){
        tasksRepository.save(task);
    }
    public String deleteTask(int id){
        Task task = tasksRepository.findById(id).orElseThrow();
        tasksRepository.delete(task);
        return "Tarefa deletada com sucesso";
    }
}
