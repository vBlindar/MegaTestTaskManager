package kg.mega.vblindar.mega_test.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateTaskDTO {

    @NotBlank
    @Size(min = 1, max= 16, message = "The theme of the task should not be empty and more than 16 characters")
    private String theme;

    private String text;

    @Email
    private String email;

}
