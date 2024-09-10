package kg.mega.vblindar.mega_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDTO {

    @NotBlank
    @Size(min = 1, max= 16, message = "The theme of the task should not be empty and more than 16 characters")
    private String theme;

    private String text;

    @Email(message = "Must be in email address format")
    private String email;

}
