package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduler {

    @Autowired
    private TaskService taskService;

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    public void deleteExpiredTasks() {
        taskService.deleteExpiredTasks();
    }
}
