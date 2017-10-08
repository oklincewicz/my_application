package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return (List<Task>) repository.findAll();
    }

    public Task getTaskById(final Long id) {
        Optional<Task> task = repository.findById(id);
        if(task.isPresent()) {
            return task.get();
        } else {
            return null;
        }
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public void deleteTaskById(final Long id) {
        repository.deleteById(id);
    }
}
