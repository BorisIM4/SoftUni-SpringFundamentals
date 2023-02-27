package bg.borismilanov.state.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieController {

    @GetMapping("/cookies")
    public String cookies(Model model ) {

        model.addAttribute("lang", "en");
        return "cookies";
    }

//    @PostMapping("/cookies")
//    public String cookies() {
//        return "redirect:/cookies";
//    }
}
