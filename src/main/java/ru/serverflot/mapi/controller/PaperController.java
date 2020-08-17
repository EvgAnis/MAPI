package ru.serverflot.mapi.controller;

import ru.serverflot.mapi.model.Paper;
import ru.serverflot.mapi.repository.PaperRepository;
import ru.serverflot.mapi.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private HistoryRepository historyRepository;


    @GetMapping("/papers/{Id}")
    public List<Paper> getAnswersByQuestionId(@PathVariable Long Id) {
        return paperRepository.findBySecid(Id);
    }
//
//    @PostMapping("/questions/{questionId}/answers")
//    public Paper addAnswer(@PathVariable Long questionId,
//                           @Valid @RequestBody Paper paper) {
//        return historyRepository.findById(questionId)
//                .map(paperHistory -> {
//                    paper.setPaperHistory(paperHistory);
//                    return paperRepository.save(paper);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
//
//    @PutMapping("/questions/{questionId}/answers/{answerId}")
//    public Paper updateAnswer(@PathVariable Long questionId,
//                              @PathVariable Long answerId,
//                              @Valid @RequestBody Paper paperRequest) {
//        if(!historyRepository.existsById(questionId)) {
//            throw new ResourceNotFoundException("Question not found with id " + questionId);
//        }
//
//        return paperRepository.findById(answerId)
//                .map(paper -> {
//                    paper.setText(paperRequest.getText());
//                    return paperRepository.save(paper);
//                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
//    }
//
//    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
//    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
//                                          @PathVariable Long answerId) {
//        if(!historyRepository.existsById(questionId)) {
//            throw new ResourceNotFoundException("Question not found with id " + questionId);
//        }
//
//        return paperRepository.findById(answerId)
//                .map(paper -> {
//                    paperRepository.delete(paper);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
//
//    }
}
