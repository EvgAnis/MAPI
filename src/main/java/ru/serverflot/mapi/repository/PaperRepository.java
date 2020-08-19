package ru.serverflot.mapi.repository;

import ru.serverflot.mapi.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findBySecid(Long Id);
    List<Paper> findAllBytradedate(String date);
}
