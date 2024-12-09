package com.example.todo.service.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/tasks")
    public String index(Model model) {
        List<Task> tasks = todoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam("title") String title, @RequestParam("deadline")LocalDateTime deadline) {
        todoService.save(title, deadline);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        todoService.toggleTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/filter")
    public String filter(
            @RequestParam(value = "completed", required = false) String completed,
            @RequestParam(value = "sort", required = false) String sort
            , Model model) {

        List<Task> tasks = todoService.getAllTasks();

//        System.out.println(completed);

        /*
        *   Collectors.toList() gives a mutable list while simple toList() gives a immutable.
        *   We can't sort an immutable list.
        * */

        // Filter Logic
        if(completed != null && !completed.isEmpty()) {
            boolean isCompleted = Boolean.parseBoolean(completed); // Option Values are true and false
            tasks = tasks.stream().filter(task -> task.isCompleted() == isCompleted).collect(Collectors.toList());
        }

        // Sorting Logic
        if(sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "title_asc": tasks.sort(Comparator.comparing(Task::getTitle)); break;
                case "title_desc": tasks.sort(Comparator.comparing(Task::getTitle).reversed()); break;
                case "completed": tasks.sort(Comparator.comparing(Task::isCompleted)); break;
                case "deadline": tasks.sort(Comparator.comparing(Task::getDeadline)); break;
            }
        }

        model.addAttribute("tasks", tasks);
        return "index";
    }
}
