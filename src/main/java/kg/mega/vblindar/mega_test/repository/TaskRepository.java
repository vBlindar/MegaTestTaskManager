package kg.mega.vblindar.mega_test.repository;


import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.entity.TaskData;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    Task findById(Long id);

    void delete(Task task);

    List<Task> findAll();
}
