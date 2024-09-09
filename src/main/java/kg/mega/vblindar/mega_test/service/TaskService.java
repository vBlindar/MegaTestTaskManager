package kg.mega.vblindar.mega_test.service;

import kg.mega.vblindar.mega_test.controller.TaskDTO;
import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    Task create(CreateTaskDTO taskDTO);
}
