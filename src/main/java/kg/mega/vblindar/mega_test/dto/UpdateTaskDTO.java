package kg.mega.vblindar.mega_test.dto;


import lombok.Data;

@Data
public class UpdateTaskDTO extends CreateTaskDTO {
    private Long id;

    public UpdateTaskDTO(Long id, String theme, String text, String email) {
        super(theme, text, email);
        this.id = id;
    }
}
