package kg.mega.vblindar.mega_test.controller;

import kg.mega.vblindar.mega_test.domain.Task;
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
    private String mail;

    public static TaskDTO from(Task task) {
        return new TaskDTO(task.getId(),
                task.getTheme(),
                task.getText(),
                task.getCreatedAt(),
                task.getLastUpdate(),
                task.getMail());
    }


}
