package kg.mega.vblindar.mega_test.service.impl;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.entity.TaskData;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task create(CreateTaskDTO taskDTO) {
        TaskData task = new TaskData();
        task.setTheme(taskDTO.getTheme());
        task.setText(taskDTO.getText());
        task.setMail(taskDTO.getMail());
        task.setCreatedAt(LocalDateTime.now());
        task.setLastUpdate(LocalDateTime.now());


        return taskRepository.save(task);
    }
}
