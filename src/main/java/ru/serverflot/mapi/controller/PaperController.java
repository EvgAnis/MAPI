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
    @GetMapping("/papers/truncate")
    public String truncatePapers() {
        paperRepository.deleteAll();
        return "<html><meta http-equiv=\"refresh\" content=\"0; url=/\" /></html>";
    }
    @GetMapping("/papers/delete/{id}")
    public String deleteByIdPapers(@PathVariable Long id) {
        paperRepository.deleteById(id);
        return "<html><meta http-equiv=\"refresh\" content=\"0; url=/\" /></html>";
    }
    @GetMapping("/papers/add/{secid}/{name}/{emitent_title}/{tradedate}/{numtrades}/{open}/{close}")
    public String deleteByIdPapers(@PathVariable String secid,
                                   @PathVariable String name,
                                   @PathVariable String emitent_title,
                                   @PathVariable String tradedate,
                                   @PathVariable Integer numtrades,
                                   @PathVariable Double open,
                                   @PathVariable Double close) {
        Paper paper = new Paper(secid, name, emitent_title, tradedate, numtrades, open, close);
        paperRepository.save(paper);
        return "<html><meta http-equiv=\"refresh\" content=\"0; url=/\" /></html>";
    }
}
