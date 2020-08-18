package ru.serverflot.mapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.serverflot.mapi.repository.PaperRepository;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    PaperRepository paperRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String uploadFile(Model model) {
        return "upload";
    }
}
