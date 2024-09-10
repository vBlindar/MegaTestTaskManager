package kg.mega.vblindar.mega_test.service.impl;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.domain.TaskStatus;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.dto.UpdateTaskDTO;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final EmailServiceImpl emailService;

    @CacheEvict(value = "tasksCache", allEntries = true)
    @Override
    public Task create(CreateTaskDTO taskDTO) {

        Task task = new Task();
        task.setTheme(taskDTO.getTheme());
        task.setText(taskDTO.getText());
        task.setCreatedAt(LocalDateTime.now());
        task.setLastUpdate(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);

        if(taskDTO.getEmail()!=null){
            task.setEmail(taskDTO.getEmail());
            emailService.sendMail(taskDTO);
        }

        return taskRepository.save(task);
    }

    @CacheEvict(value = "tasksCache", allEntries = true)
    @Override
    public Task update(UpdateTaskDTO taskDTO) {
        var task = taskRepository.findById(taskDTO.getId());

        task.setTheme(taskDTO.getTheme());
        task.setText(taskDTO.getText());
        if (taskDTO.getEmail() != null)
            task.setEmail(taskDTO.getEmail());
        else
            task.setEmail(null);
        task.setLastUpdate(LocalDateTime.now());
        task.setStatus(taskDTO.getStatus());
        return taskRepository.save(task);
    }
    @CacheEvict(value = "tasksCache", allEntries = true)
    @Override
    public void delete(Long id) {
        var task = taskRepository.findById(id);
        taskRepository.delete(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id);
    }


    @Cacheable(value = "tasksCache")
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }


}
