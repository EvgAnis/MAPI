package ru.serverflot.mapi.controller;

import ru.serverflot.mapi.model.History;
import ru.serverflot.mapi.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/history")
    public Page<History> getQuestions(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }

//
//    @PostMapping("/questions")
//    public History createQuestion(@Valid @RequestBody History question) {
//        return historyRepository.save(question);
//    }
//
//    @PutMapping("/questions/{questionId}")
//    public History updateQuestion(@PathVariable Long questionId,
//                                  @Valid @RequestBody History questionRequest) {
//        return historyRepository.findById(questionId)
//                .map(question -> {
//                    question.setTitle(questionRequest.getTitle());
//                    question.setDescription(questionRequest.getDescription());
//                    return historyRepository.save(question);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
//
//
//    @DeleteMapping("/questions/{questionId}")
//    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
//        return historyRepository.findById(questionId)
//                .map(question -> {
//                    historyRepository.delete(question);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
}
