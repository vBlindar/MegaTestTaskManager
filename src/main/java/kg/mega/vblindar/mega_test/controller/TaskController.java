package kg.mega.vblindar.mega_test.controller;

import kg.mega.vblindar.mega_test.dto.*;
import kg.mega.vblindar.mega_test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    ResponseEntity<TaskDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(200).body(TaskDTO.from(taskService.findById(id)));
    }

    @GetMapping("/all")
    ResponseEntity<ListOfTasksDTO> findAll(){
        return ResponseEntity.status(200).body(ListOfTasksDTO.from(taskService.findAll()));
    }


    @PostMapping
    ResponseEntity<TaskDTO> create(@RequestBody @Validated CreateTaskDTO taskDTO) {
        return ResponseEntity.status(201).body(TaskDTO.from(taskService.create(taskDTO)));
    }

    @PutMapping
    ResponseEntity<TaskDTO> update(@RequestBody @Validated UpdateTaskDTO taskDTO){
        return ResponseEntity.status(200).body(TaskDTO.from(taskService.update(taskDTO)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.status(204).body(id);
    }



}
