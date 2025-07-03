package com.example.todo.controller;

import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.create(task);
    }

    @GetMapping
    public List<Task> getRecentTasks() {
        return service.getRecentIncompleteTasks();
    }

    @PutMapping("/{id}/complete")
    public void completeTask(@PathVariable Long id) {
        service.markAsDone(id);
    }
}