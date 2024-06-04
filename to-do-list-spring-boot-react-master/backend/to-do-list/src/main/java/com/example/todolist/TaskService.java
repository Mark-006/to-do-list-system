package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    

    public void deleteExpiredTasks() {
        LocalDateTime now = LocalDateTime.now();
        List<Task> expiredTasks = taskRepository.findByEndTimeBeforeAndStatus(now, "expired");
        taskRepository.deleteAll(expiredTasks);
    }
}
