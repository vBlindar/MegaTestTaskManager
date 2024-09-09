package kg.mega.vblindar.mega_test.controller;

import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    ResponseEntity<String> findAll() {
        return ResponseEntity.ok("String");
    }

    @PostMapping
    ResponseEntity<TaskDTO> create(@RequestBody @Validated CreateTaskDTO taskDTO) {

        return ResponseEntity.ok(TaskDTO.from(taskService.create(taskDTO)));
    }

}
