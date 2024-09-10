package kg.mega.vblindar.mega_test.dto;


import kg.mega.vblindar.mega_test.domain.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskDTO extends CreateTaskDTO {
    private Long id;
    private TaskStatus status;

    public UpdateTaskDTO(Long id, String theme, String text, String email,TaskStatus status) {
        super(theme, text, email);
        this.id = id;
        this.status = status;
    }
}
