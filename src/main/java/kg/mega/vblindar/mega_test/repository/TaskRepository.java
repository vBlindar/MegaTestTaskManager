package kg.mega.vblindar.mega_test.repository;


import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.entity.TaskData;

public interface TaskRepository {
    Task save(TaskData task);
}
