package com.example.demo.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    @Autowired
    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${google.books.api.url}")
    private String googleBooksApiUrl;

    public List<Book> searchBooks(String query) {
        String apiUrl = googleBooksApiUrl + "?q=" + query;
        ResponseEntity<BookApiResponse> response = restTemplate.getForEntity(apiUrl, BookApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            BookApiResponse body = response.getBody();
            if (body != null && body.getItems() != null) {

                return mapToBooks(body.getItems());
            }
        }
        return null;
    }

    private List<Book> mapToBooks(List<BookApiItem> items) {
        return items.stream()
                .map(this::mapToBook)
                .collect(Collectors.toList());
    }

    private Book mapToBook(BookApiItem item) {
        Book book = new Book();
        book.setTitle(item.getVolumeInfo().getTitle());
        book.setAuthors(item.getVolumeInfo().getAuthors());
        book.setDescription(item.getVolumeInfo().getDescription());
        book.setGenre(Arrays.toString(item.getVolumeInfo().getCategories().toArray()));
        book.setPublishedDate(item.getVolumeInfo().getPublishedDate());
        return book;
    }
}