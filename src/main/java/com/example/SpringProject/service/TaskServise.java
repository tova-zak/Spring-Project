package com.example.SpringProject.service;

import com.example.SpringProject.entities.Task;
import com.example.SpringProject.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServise {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() { return taskRepository.findAll(); }

    public Task getTaskById(Long id) { return taskRepository.findById(id).orElse(null); }

    public Task createTask(Task task) { return taskRepository.save(task); }

    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted";
    }
    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public List<Task> getTasksAfterDate(Date date) {
        return taskRepository.findByCreatedAtAfter(date);
    }
}