package com.georgievl.spring6webapp.bootstrap;

import com.georgievl.spring6webapp.domain.Author;
import com.georgievl.spring6webapp.domain.Book;
import com.georgievl.spring6webapp.domain.Publisher;
import com.georgievl.spring6webapp.repositories.AuthorRepository;
import com.georgievl.spring6webapp.repositories.BookRepository;
import com.georgievl.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setPublisherName("The Publisher");
        publisher.setAddress("123 Johnson Str.");
        publisher.setCity("Windy Springs");
        publisher.setState("WY");
        publisher.setZip("88921");

        Publisher savedPublisher = publisherRepository.save(publisher);

        System.out.println("In BootstrapData");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
