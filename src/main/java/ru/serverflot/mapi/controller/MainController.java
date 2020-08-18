package ru.serverflot.mapi.controller;

import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    PaperRepository paperRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Paper> papers = paperRepository.findAll(); // NULL ! Must be data here
        model.addAttribute("papers", papers);
        model.addAttribute("title", "Market API");

        return "home";
    }

    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("title", "Help");
        return "help";
    }
}
