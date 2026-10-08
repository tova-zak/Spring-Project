package com.example.SpringProject.controller;

import com.example.SpringProject.entities.Task;
import com.example.SpringProject.service.TaskServise;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks") // שונה ל-/tasks
@RequiredArgsConstructor
public class TaskController {
    private final TaskServise taskService;

    @GetMapping
    public List<Task> getAll() { return taskService.getAllTasks(); }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) { return taskService.getTaskById(id); }

    @PostMapping
    public Task create(@RequestBody Task task) { return taskService.createTask(task); }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) { return taskService.updateTask(id, task); }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { return taskService.deleteTask(id); }
    @GetMapping("/status/{completed}")
    public List<Task> getByStatus(@PathVariable boolean completed) {
        return taskService.getTasksByStatus(completed);
    }

    @GetMapping("/after-date/{date}")
    public List<Task> getAfterDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return taskService.getTasksAfterDate(date);
    }
}