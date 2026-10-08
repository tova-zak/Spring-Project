package com.example.SpringProject.repository;

import com.example.SpringProject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByCompleted(boolean completed);
    List<Task> findByCreatedAtAfter(Date date);

}
