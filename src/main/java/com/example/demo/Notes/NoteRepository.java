package com.example.demo.Notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);

    Note findByContentContaining(String keyword);

    Note findByTitleAndContent(String title, String content);

    Note findByTitleStartingWith(String prefix);

    Note findAllByOrderById();
}
