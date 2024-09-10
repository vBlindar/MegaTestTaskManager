package kg.mega.vblindar.mega_test.service;

import kg.mega.vblindar.mega_test.domain.Task;
import kg.mega.vblindar.mega_test.domain.TaskStatus;
import kg.mega.vblindar.mega_test.dto.CreateTaskDTO;
import kg.mega.vblindar.mega_test.dto.UpdateTaskDTO;
import kg.mega.vblindar.mega_test.repository.TaskRepository;
import kg.mega.vblindar.mega_test.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;

    private Task updated;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        task = new Task();
        task.setId(1L);
        task.setTheme("Test Task");
        task.setText("This is a test task");
        task.setEmail("test@example.com");
        task.setCreatedAt(LocalDateTime.now());
        task.setLastUpdate(LocalDateTime.now());


        updated = new Task();
        updated.setId(2L);
        updated.setTheme("Updated Task");
        updated.setText("Updated text");
        updated.setEmail("updated@example.com");
        updated.setCreatedAt(LocalDateTime.now());
        updated.setLastUpdate(LocalDateTime.now());
        updated.setStatus(TaskStatus.COMPLETED);
    }

    @Test
    void createTaskTest() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.create(new CreateTaskDTO("Test Task", "This is a test task", "test@example.com"));

        verify(taskRepository, times(1)).save(any(Task.class));

        assertNotNull(createdTask);
        assertEquals("Test Task", createdTask.getTheme());
    }


    @Test
    void deleteTaskTest() {
        when(taskRepository.findById(anyLong())).thenReturn(task);

        taskService.delete(1L);

        verify(taskRepository, times(1)).findById(anyLong());
        verify(taskRepository, times(1)).delete(any(Task.class));
    }

    @Test
    void findByIdTest() {
        when(taskRepository.findById(anyLong())).thenReturn(task);

        Task foundTask = taskService.findById(1L);

        verify(taskRepository, times(1)).findById(1L);
        assertNotNull(foundTask);
        assertEquals(1L, foundTask.getId());
    }

    @Test
    void findAllTasksTest() {
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task));

        List<Task> allTasks = taskService.findAll();

        verify(taskRepository, times(1)).findAll();

        assertFalse(allTasks.isEmpty());
        assertEquals(1, allTasks.size());
        assertEquals("Test Task", allTasks.get(0).getTheme());
    }

    @Test
    void updateTaskTest() {
        when(taskRepository.findById(anyLong())).thenReturn(task);
        UpdateTaskDTO updateTaskDTO = new UpdateTaskDTO(1L, "Updated Task", "Updated text", "updated@example.com", TaskStatus.COMPLETED);
        when(taskRepository.save(any())).thenReturn(updated);

        Task updatedTask = taskService.update(updateTaskDTO);

        verify(taskRepository, times(1)).findById(anyLong());
        verify(taskRepository, times(1)).save(any(Task.class));

        assertEquals("Updated Task", updatedTask.getTheme());
        assertEquals("Updated text", updatedTask.getText());
        assertEquals("updated@example.com", updatedTask.getEmail());
        assertEquals(TaskStatus.COMPLETED,updatedTask.getStatus());
    }
}
