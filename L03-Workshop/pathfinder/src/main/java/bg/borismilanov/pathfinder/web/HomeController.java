package bg.borismilanov.pathfinder.web;

import bg.borismilanov.pathfinder.model.Route;
import bg.borismilanov.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Route> route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route.get(0));

        return "index";
    }


}
