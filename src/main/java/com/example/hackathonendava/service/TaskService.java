package com.example.hackathonendava.service;



import com.example.hackathonendava.exception.NotFoundException;
import com.example.hackathonendava.model.Task;
import com.example.hackathonendava.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private Logger logger = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

//        if (optionalTask.isPresent()) {
//            return optionalTask.get();
//        } else {
//            logger.warn("Task not found!");
//            throw new RuntimeException("Task not found!");
//        }
        return optionalTask.orElseThrow(() -> new NotFoundException("Task not found!", "task.not.found"));
    }

    public Task saveTask(Task task) {
        task.setStage("To do");
        return taskRepository.save(task);
    }
    public void deleteTask(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            taskRepository.delete(taskOptional.get());
        }else{
            throw new NotFoundException("Task not found!", "task.not.found");
        }
    }

//    public Task updateTask(Long id, Task taskUpdated){
//        Optional<Task> taskOptional = taskRepository.findById(id);
//        if(taskOptional.isPresent()){
//            taskUpdated.setId(id);
//            return taskRepository.save(taskUpdated);
//
//        }else {
//            throw new RuntimeException("Task not found!");
//        }
//    }

    public Task updateTask(Long id, Task taskUpdated) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            taskUpdated.setId(id);
            taskUpdated.setName(taskUpdated.getName() == null ? taskOptional.get().getName() : taskUpdated.getName());
            taskUpdated.setDeadline(taskUpdated.getDeadline() == null ? taskOptional.get().getDeadline() : taskUpdated.getDeadline());
            taskUpdated.setDescription(taskUpdated.getDescription() == null ? taskOptional.get().getDescription() : taskUpdated.getDescription());
            taskUpdated.setStage(taskUpdated.getStage() == null ? taskOptional.get().getStage() : taskUpdated.getStage());

            return taskRepository.save(taskUpdated);
        } else {
            throw new NotFoundException("Task not found!", "task.not.found");
        }
    }


    public Task getDemoTask(){
        Task task = new Task();
        task.setId(1L);

        task.setName("Eseu biologie");
        task.setDeadline(LocalDate.now().plusDays(10));
        task.setStage("To do");
        task.setDescription("Generic task description..");

        return task;

    }
}
