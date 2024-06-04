package com.example.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEndTimeBeforeAndStatus(LocalDateTime endTime, String status);
}
