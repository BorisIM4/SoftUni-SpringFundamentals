package com.plannerapp.controller;

import com.plannerapp.model.dtos.TaskAddDTO;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ModelAttribute("taskAddDTO")
    public TaskAddDTO initAddTask(){
        return new TaskAddDTO();
    }

    @GetMapping("/task-add")
    public String task() {
        return "task-add";
    }

    @PostMapping("/task-add")
        public String task(@Valid TaskAddDTO taskAddDTO,
                BindingResult bindingResult,
                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.taskService.addTask(taskAddDTO)) {
            redirectAttributes.addFlashAttribute("createShipDTO", taskAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO",
                    bindingResult);

            return "redirect:/task-add";
        }
        return "redirect:/home";
    }
}
