package com.siemplify.producer.api;

import com.siemplify.producer.dto.TaskDto;
import com.siemplify.producer.model.Task;
import com.siemplify.producer.repository.TaskRepository;
import com.siemplify.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;

@RestController
@RequestMapping(ProducerController.PREFIX_URL)
public class ProducerController {

    public static final String PREFIX_URL = "/api/producer";

    @Autowired
    private ProducerService producerService;
    @Autowired
    private TaskRepository taskRepo;

    @GetMapping("/test")
    public ResponseEntity<String> test() {

        try {
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return new ResponseEntity("Test failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task/submit")
    public ResponseEntity<Task> produceTask(@RequestBody @Validated TaskDto taskDto) {

        try {
            Task newTask =  new Task(taskDto.getTaskText(), taskDto.getConsumerId());
            Task entity = taskRepo.save(newTask);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return new ResponseEntity("Failed to produce task", HttpStatus.BAD_REQUEST);
        }
    }
}
