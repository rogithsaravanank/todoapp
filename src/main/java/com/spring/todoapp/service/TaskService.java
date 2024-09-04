package com.spring.todoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.spring.todoapp.model.Task;
import org.springframework.stereotype.Service;
import com.spring.todoapp.repo.TaskRepository;

@Service
public class TaskService{

    @Autowired
    TaskRepository repo;

    public List<Task> getTasks() {
        return repo.findAll();
    }

    public void postTasks(Task task) {
        repo.save(task);
    }

    public void putTasks(Long id, Task task) {
        Optional<Task> existingTask = repo.findById(id);

        if(existingTask.isPresent()){
            Task updTask=existingTask.get();

            updTask.setTitle(task.getTitle());
            updTask.setDueDate(task.getDueDate());
            updTask.setStatus(task.getStatus());
            updTask.setDescription(task.getDescription());

            repo.save(updTask);
        }

    }

    public void deleteTasks(Long id) {
        Optional<Task> existingTask = repo.findById(id);
        Task updTask=existingTask.get();
        repo.delete(updTask);
    }


}