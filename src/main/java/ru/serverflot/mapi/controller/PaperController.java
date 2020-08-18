package ru.serverflot.mapi.controller;

import org.springframework.ui.Model;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaperController {

    @Autowired
    private PaperRepository paperRepository;

    @GetMapping("/papers")
    public List<Paper> papers(Model model) {
        return paperRepository.findAll();
    }
    @GetMapping("/papers/{id}")
    public Optional<Paper> papersById(@PathVariable Long id) {
        return paperRepository.findById(id);
    }

}
