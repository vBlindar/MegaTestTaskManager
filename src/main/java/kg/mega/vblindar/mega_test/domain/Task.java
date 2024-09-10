package kg.mega.vblindar.mega_test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    Long id;
    String theme;
    String text;
    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    String email;
    TaskStatus status;

}
