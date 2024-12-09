package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public void save(String title, LocalDateTime deadline) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setDeadline(deadline);
        taskRepository.save(task);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if(task != null) {
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id).ifPresent(taskRepository::delete);
    }
}
