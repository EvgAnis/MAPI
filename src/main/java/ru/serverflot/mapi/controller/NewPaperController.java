package ru.serverflot.mapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;

@Controller
@RequestMapping("/new")
public class NewPaperController {
    @Autowired
    PaperRepository paperRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String newPaper() {
        return "new";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String newPaperPost(@RequestParam("secid") String secid,
                               @RequestParam("name") String name,
                               @RequestParam("emitent_title") String emitent_title,
                               @RequestParam("tradedate") String tradedate,
                               @RequestParam("numtrades") Integer numtrades,
                               @RequestParam("open") Double open,
                               @RequestParam("close") Double close) {
        Paper paper = new Paper(secid, name, emitent_title, tradedate, numtrades, open, close);
        paperRepository.save(paper);
        return "redirect:/";
    }
}
