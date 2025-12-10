package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chefs")
public class ChefController {

    private final ChefService chefService;
    private final DishService dishService;

    public ChefController(ChefService chefService, DishService dishService) {
        this.chefService = chefService;
        this.dishService = dishService;
    }

    // LIST ALL CHEFS
    @GetMapping
    public String getChefsPage(Model model,
                               @RequestParam(required = false) String error) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
        }

        model.addAttribute("chefs", chefService.listAll());
        return "listChef";
    }

    // DETAILS PAGE FOR SELECTED CHEF
    @GetMapping("/{id}")
    public String getChefDetails(@PathVariable Long id, Model model) {

        Chef chef = chefService.findById(id);
        if (chef == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }

        model.addAttribute("chef", chef);
        model.addAttribute("dishes", dishService.listByChef(id));

        return "chefDetails";
    }

    // SIMPLE REDIRECT SELECTOR
    @GetMapping("/select")
    public String selectChefRedirect(@RequestParam Long id) {
        return "redirect:/chefs/" + id;
    }
}
