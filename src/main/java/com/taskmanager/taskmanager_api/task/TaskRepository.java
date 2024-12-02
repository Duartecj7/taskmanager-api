package com.taskmanager.taskmanager_api.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByStatus(Task.Status status);
    List<Task> findByCategoryName(String category);
    List<Task> findByDueDateBefore(LocalDateTime now);
}
