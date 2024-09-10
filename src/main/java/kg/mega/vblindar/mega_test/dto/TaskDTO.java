package kg.mega.vblindar.mega_test.dto;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.domain.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String theme;
    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String email;
    private TaskStatus status;

    public static TaskDTO from(Task task) {
        return new TaskDTO(task.getId(),
                task.getTheme(),
                task.getText(),
                task.getCreatedAt(),
                task.getLastUpdate(),
                task.getEmail(),
                task.getStatus());
    }


}
