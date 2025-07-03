package com.example.todo.service;

import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private TaskRepository repository;
    private TaskService service;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        service = new TaskService(repository);
    }

    @Test
    void testGetRecentIncompleteTasks() {
        List<Task> mockTasks = Arrays.asList(
                new Task(1L, "Task 1", "Desc 1", false, null),
                new Task(2L, "Task 2", "Desc 2", false, null)
        );

        when(repository.findTop5ByCompletedFalseOrderByCreatedAtDesc()).thenReturn(mockTasks);

        List<Task> result = service.getRecentIncompleteTasks();

        assertEquals(2, result.size());
        verify(repository, times(1)).findTop5ByCompletedFalseOrderByCreatedAtDesc();
    }

    @Test
    void testMarkAsDone() {
        Task task = new Task(1L, "Sample Task", "desc", false, null);
        when(repository.findById(1L)).thenReturn(Optional.of(task));

        service.markAsDone(1L);

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(repository).save(taskCaptor.capture());

        Task savedTask = taskCaptor.getValue();
        assertTrue(savedTask.isCompleted());
    }
}
