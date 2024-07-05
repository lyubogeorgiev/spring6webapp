package com.georgievl.spring6webapp.services;

import com.georgievl.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAllBooks();
}
