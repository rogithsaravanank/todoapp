package com.spring.todoapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.todoapp.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{


    
}
