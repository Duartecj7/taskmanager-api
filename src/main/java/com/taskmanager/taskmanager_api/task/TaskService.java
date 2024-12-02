package com.taskmanager.taskmanager_api.task;

import com.taskmanager.taskmanager_api.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }
    public Task updateTask(Long id, Task updatedTask ){
        Task task =taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não foi encontrada"));
        task.setTittle(updatedTask.getTittle());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setStatus(updatedTask.getStatus());
        task.setCategory(updatedTask.getCategory());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(Task.Status status){
        return taskRepository.findByStatus(status);
    }
    public List<Task> getTasksByCategory(String category){
        return taskRepository.findByCategoryName(category);
    }
    public List<Task> getOverdueTasks(){
        return taskRepository.findByDueDateBefore(LocalDateTime.now());
    }
    public Task updateTaskStatus(Long id, Task.Status status){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa nao econtrada"));
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
