package bg.borismilanov.battleships.controllers;

import bg.borismilanov.battleships.models.dtos.CreateShipDTO;
import bg.borismilanov.battleships.services.AuthService;
import bg.borismilanov.battleships.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    @ModelAttribute("createShipDTO")
    public CreateShipDTO initCreateShipDTO() {
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String ships(){
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO",
                    bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }

}
