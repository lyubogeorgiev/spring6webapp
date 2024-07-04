package com.georgievl.spring6webapp.bootstrap;

import com.georgievl.spring6webapp.domain.Author;
import com.georgievl.spring6webapp.domain.Book;
import com.georgievl.spring6webapp.repositories.AuthorRepository;
import com.georgievl.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Davis");

        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("123456");

        Author savedAuthor = authorRepository.save(eric);
        Book savedBook = bookRepository.save(book);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("The EJB");
        noEJB.setIsbn("789123");

        Author savedAuthor2 = authorRepository.save(rod);
        Book savedBook2 = bookRepository.save(noEJB);

        savedAuthor.getBooks().add(book);
        savedAuthor2.getBooks().add(noEJB);

        authorRepository.save(savedAuthor);
        authorRepository.save(savedAuthor2);

        System.out.println("In BootstrapData");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
