package com.plannerapp.service;

import com.plannerapp.model.dtos.TaskAddDTO;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, LoggedUser userSession) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean addTask(TaskAddDTO taskAddDTO){

        String username = userSession.getUsername();

        Optional<UserEntity> byUsername = this.userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            UserEntity user = byUsername.get();

            TaskEntity task = new TaskEntity();

            task.setUser(user);
            task.setDescription(taskAddDTO.getDescription());
            task.setDueDate(taskAddDTO.getDueDate());
            task.setPriority(taskAddDTO.getPriority());

            this.taskRepository.save(task);

            
            return true;
        }

        return true;
    }
}
