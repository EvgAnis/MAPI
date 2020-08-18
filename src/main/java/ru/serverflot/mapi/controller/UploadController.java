package ru.serverflot.mapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    PaperRepository paperRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String uploadFile(Model model) {
        return "upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException, ParseException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);

//        JSONParser parser = new JSONParser(content);
//        Map<String, List<Paper>> result1 = parser.parse(Map.class, content);
//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        Paper paper = objectMapper.readValue(content, Paper.class);
        paperRepository.save(paper);

        return "redirect:/";
    }

}
