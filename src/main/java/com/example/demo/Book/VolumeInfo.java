package com.example.demo.Book;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String description;
    private List<String> categories;
    private String publishedDate;

}
