package com.example.demo.appuser;

import com.example.demo.Course.Course;
import com.example.demo.Notes.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    private AppUserService userService;
    @GetMapping("{userId}/courses")
    public ResponseEntity<List<Course>> getAllCourses(@PathVariable Long userId) {
        List<Course> courses = userService.getAllCourses(userId);
        return ResponseEntity.ok(courses);
    }
    @GetMapping("{userId}/notes")
    public ResponseEntity<List<Note>> getAllNotes(@PathVariable Long userId) {
        List<Note> notes = userService.getAllNotes(userId);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}
