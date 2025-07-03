package com.example.todo.controller;

import com.example.todo.entity.Task;
import com.example.todo.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    private List<Task> taskList;

    @BeforeEach
    void setUp() {
        taskList = Arrays.asList(
                new Task(1L, "Task 1", "Desc 1", false, null),
                new Task(2L, "Task 2", "Desc 2", false, null)
        );
    }

    @Test
    void shouldReturnListOfTasks() throws Exception {
        when(taskService.getRecentIncompleteTasks()).thenReturn(taskList);

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Task 1")))
                .andExpect(jsonPath("$[1].title", is("Task 2")));
    }

    @Test
    void shouldCreateNewTask() throws Exception {
        Task newTask = new Task(null, "New Task", "Test Desc", false, null);
        Task savedTask = new Task(3L, "New Task", "Test Desc", false, null);

        when(taskService.create(any(Task.class))).thenReturn(savedTask);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"title":"New Task","description":"Test Desc"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.title", is("New Task")));
    }

    @Test
    void shouldMarkTaskAsDone() throws Exception {
        doNothing().when(taskService).markAsDone(1L);

        mockMvc.perform(put("/api/tasks/1/complete"))
                .andExpect(status().isOk());

        verify(taskService, times(1)).markAsDone(1L);
    }
}