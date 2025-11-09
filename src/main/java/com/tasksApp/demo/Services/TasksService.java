package com.tasksApp.demo.Services;

import com.tasksApp.demo.Entity.Task;
import com.tasksApp.demo.Repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Task> getTasksCompleted(){
        return tasksRepository.findByIsCompletedTrue();
    }
    public List<Task> getTasksIncomplete(){
        return tasksRepository.findByIsCompletedFalse();
    }

    public void createTask(Task task){
        tasksRepository.save(task);
    }
    public void changeDescription(int id, Task newDescription){
        Optional<Task> existingTask = tasksRepository.findById(id);
        if(existingTask.isEmpty()){
            throw new RuntimeException("Tarefa não encontrada");
        }
        Task task = existingTask.get();

        if(newDescription.getDescription() != null){
            task.setDescription(newDescription.getDescription());
        }
        tasksRepository.save(task);
    }
    public Task markAsCompleted(int id){
        Task task = tasksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        task.setCompleted(true);

        return tasksRepository.save(task);
    }
    public Task markAsIncomplete(int id){
        Task task = tasksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        task.setCompleted(false);
        return tasksRepository.save(task);
    }

    public String deleteTask(int id){
        Task task = tasksRepository.findById(id).orElseThrow();
        tasksRepository.delete(task);
        return "Tarefa deletada com sucesso";
    }
}
