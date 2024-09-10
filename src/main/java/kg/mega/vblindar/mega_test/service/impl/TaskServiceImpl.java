package kg.mega.vblindar.mega_test.service.impl;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.dto.TaskDTO;
import kg.mega.vblindar.mega_test.dto.UpdateTaskDTO;
import kg.mega.vblindar.mega_test.entity.TaskData;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task create(CreateTaskDTO taskDTO) {

        Task task = new Task();
        task.setTheme(taskDTO.getTheme());
        task.setText(taskDTO.getText());
        task.setEmail(taskDTO.getEmail());
        task.setCreatedAt(LocalDateTime.now());
        task.setLastUpdate(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Override
    public Task update(UpdateTaskDTO taskDTO) {
        var task = taskRepository.findById(taskDTO.getId());

        task.setTheme(task.getTheme());
        task.setText(taskDTO.getText());
        if(taskDTO.getEmail()!=null)
            task.setEmail(task.getEmail());
        task.setLastUpdate(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        var task = taskRepository.findById(id);
        taskRepository.delete(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }


}
