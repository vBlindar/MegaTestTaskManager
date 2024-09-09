package kg.mega.vblindar.mega_test.repository.impl;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.entity.TaskData;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.repository.jpa.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
private final JpaTaskRepository repository;
    @Override
    public Task save(TaskData task) {
        return repository.save(task).fromThis();
    }
}
