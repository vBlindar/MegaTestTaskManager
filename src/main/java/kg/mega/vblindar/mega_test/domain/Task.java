package kg.mega.vblindar.mega_test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    Long id;
    String theme;
    String text;
    LocalDateTime createdAt;
    LocalDateTime lastUpdate;
    String email;

}
