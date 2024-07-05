package com.georgievl.spring6webapp.services;

import com.georgievl.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAllAuthors();
}
