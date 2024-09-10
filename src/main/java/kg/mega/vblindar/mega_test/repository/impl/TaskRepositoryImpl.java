package kg.mega.vblindar.mega_test.repository.impl;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.entity.TaskData;
import kg.mega.vblindar.mega_test.exception.NotFoundException;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.repository.jpa.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
    private final JpaTaskRepository repository;

    @Override
    public Task save(Task task) {

        return repository.save(TaskData.from(task)).fromThis();
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Task " + id + " not found")).fromThis();
    }

    @Override
    public void delete(Task task) {
        repository.delete(TaskData.from(task));
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream().map(TaskData::fromThis).collect(Collectors.toList());
    }
}
