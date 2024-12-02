package com.taskmanager.taskmanager_api.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.taskmanager.taskmanager_api.category.Category;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Task {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @NotNull(message = "Titulo obrigatório")
    private String tittle;
   private String description;
    @NotNull(message = "Data de vencimento obrigatória")
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "status obrigatório")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public enum Status {
        PENDENTE, EM_PROGRESSO, COMPLETO
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(tittle, task.tittle) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && status == task.status && Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, description, dueDate, status, category);
    }
}
