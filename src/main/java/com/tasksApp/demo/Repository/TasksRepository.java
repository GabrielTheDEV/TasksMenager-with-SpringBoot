package com.tasksApp.demo.Repository;

import com.tasksApp.demo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer> {
    List<Task> findByIsCompletedTrue();
    List<Task> findByIsCompletedFalse();


}
