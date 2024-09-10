package kg.mega.vblindar.mega_test.dto;

import kg.mega.vblindar.mega_test.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfTasksDTO {
    private List<TaskDTO> tasks;


    public static ListOfTasksDTO from(List<Task> tasks){
        return new ListOfTasksDTO(tasks.stream().map(TaskDTO::from).collect(Collectors.toList()));
    }
}
