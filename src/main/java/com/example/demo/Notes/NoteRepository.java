package com.example.demo.Notes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserId(Long userId);
    Note findByTitle(String title);

    Note findByContentContaining(String keyword);

    Note findByTitleAndContent(String title, String content);

    Note findByTitleStartingWith(String prefix);

    Note findAllByOrderById();
}
