package kg.mega.vblindar.mega_test.repository.jpa;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.entity.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskData,Long> {
}
