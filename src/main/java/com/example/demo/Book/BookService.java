package com.example.demo.Book;

import com.example.demo.Course.CourseService;
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
    private final BookRepository bookRepository;
    private final CourseService courseService;

    @Autowired
    public BookService(RestTemplate restTemplate, BookRepository bookRepository, CourseService courseService) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
        this.courseService = courseService;
    }

    @Value("${google.books.api.url}")
    private String googleBooksApiUrl;

    public List<Book> searchBooks(String query) {
        String apiUrl = googleBooksApiUrl + "?q=" + query;
        ResponseEntity<BookApiResponse> response = restTemplate.getForEntity(apiUrl, BookApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            BookApiResponse body = response.getBody();
            if (body != null && body.getItems() != null) {

                List<Book> books = mapToBooks(body.getItems(),query);
                bookRepository.saveAll(books);
                return books;
            }
        }
        return null;
    }


    private List<Book> mapToBooks(List<BookApiItem> items, String query) {
        return items.stream()
                .map(item -> mapToBook(item,query))
                .collect(Collectors.toList());
    }


    private Book mapToBook(BookApiItem item, String query) {
        Book book = new Book();
        book.setId(item.getId());
        book.setTitle(item.getVolumeInfo().getTitle());
        book.setAuthors(item.getVolumeInfo().getAuthors());
        book.setDescription(item.getVolumeInfo().getDescription());
        book.setGenre(Arrays.toString(item.getVolumeInfo().getCategories().toArray()));
        book.setPublishedDate(item.getVolumeInfo().getPublishedDate());
        book.setCourse(courseService.getCourseByName(query));
        return book;
    }
}