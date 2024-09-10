package kg.mega.vblindar.mega_test.entity;


import kg.mega.vblindar.mega_test.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
    private String mail;


    public Task fromThis() {
        return new Task(
                id,
                theme,
                text,
                createdAt,
                lastUpdate,
                mail);

    }

    public static TaskData from(Task task){
        return new TaskData(
                task.getId(),
                task.getTheme(),
                task.getText(),
                task.getCreatedAt(),
                task.getLastUpdate(),
                task.getEmail()
        );
    }
}
