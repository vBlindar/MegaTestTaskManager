package kg.mega.vblindar.mega_test.repository;


import kg.mega.vblindar.mega_test.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
    Task save(Task task);

    Task findById(Long id);

    void delete(Task task);

    List<Task> findAll();
}
