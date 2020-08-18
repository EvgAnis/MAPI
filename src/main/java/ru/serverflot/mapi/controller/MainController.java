package ru.serverflot.mapi.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.function.IntToLongFunction;

@Controller
public class MainController {
    @Autowired
    PaperRepository paperRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Paper> papers = paperRepository.findAll();
        model.addAttribute("papers", papers);
        return "home";
    }
    @GetMapping("/sort={sortOrder}")
    public String homeOrdered(@PathVariable String sortOrder, Model model) {
        Iterable<Paper> papers = paperRepository.findAll(Sort.by(Sort.Direction.ASC, sortOrder));
        model.addAttribute("papers", papers);
        return "home";
    }

    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("title", "Help");
        return "help";
    }
}
