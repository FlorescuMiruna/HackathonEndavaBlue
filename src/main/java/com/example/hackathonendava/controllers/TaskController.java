package com.example.hackathonendava.controllers;


import com.example.hackathonendava.model.Task;
import com.example.hackathonendava.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    //    @Value("${test.value}")
//    private String value;
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/demo")
    public Task getDemoTask(){
        return taskService.getDemoTask();
    }




    @GetMapping(value = "")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("")
    public Task saveTask( @RequestBody Task task) {

        task = taskService.saveTask(task);
        return task;
    }

//    @GetMapping(value="/{id}")
//    public Task getTask(@PathVariable Long id){
//
//        return taskService.getTask(id);
//    }

    @GetMapping(value = "/param")
    public Task getParamTask(@RequestParam("id") Long id) {
        return taskService.getTask(id);
    }

//        @GetMapping(value = "/{id}")
//    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
//        try {
//            Task task = taskService.getTask(id);
//            return ResponseEntity.ok(task);
//        } catch (RuntimeException e)    {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping(value = "/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        Task task = taskService.getTask(id);

        return task;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task upateTask(@PathVariable Long id,@RequestBody Task request){
        Task task = taskService.updateTask(id,request);
        return task;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return "Greetings from my first Spring boot app :)";
    }




}