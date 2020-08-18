package ru.serverflot.mapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/import")
public class UploadController {
    @Autowired
    PaperRepository paperRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String uploadFile(Model model) {
        return "import";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        Paper[] paper = objectMapper.readValue(content, Paper[].class);
        for (int i = 0; i < paper.length; i++) {
            paperRepository.save(paper[i]);
        }

        return "redirect:/";
    }
}
