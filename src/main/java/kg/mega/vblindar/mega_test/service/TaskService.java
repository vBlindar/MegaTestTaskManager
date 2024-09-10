package kg.mega.vblindar.mega_test.service;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.dto.ListOfTasksDTO;
import kg.mega.vblindar.mega_test.dto.TaskDTO;
import kg.mega.vblindar.mega_test.dto.UpdateTaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task create(CreateTaskDTO taskDTO);

    Task update(UpdateTaskDTO taskDTO);

    void delete(Long id);

    Task findById(Long id);

    List<Task> findAll();
}
