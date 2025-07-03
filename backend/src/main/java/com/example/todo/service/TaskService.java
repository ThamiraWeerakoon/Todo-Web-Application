package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public List<Task> getRecentIncompleteTasks() {
        return repository.findTop5ByCompletedFalseOrderByCreatedAtDesc();
    }

    public void markAsDone(Long id) {
        repository.findById(id).ifPresent(task -> {
            task.setCompleted(true);
            repository.save(task);
        });
    }
}