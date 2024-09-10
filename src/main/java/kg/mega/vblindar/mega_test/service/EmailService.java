package kg.mega.vblindar.mega_test.service;

import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendMail(CreateTaskDTO taskDTO);
}
