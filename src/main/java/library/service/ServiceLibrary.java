package library.service;

import library.model.Article;
import library.model.Client;
import library.persistence.LibraryDAO;

public class ServiceLibrary {
    private final LibraryDAO jdbcBook;
    public ServiceLibrary(LibraryDAO jdbcBook){
        this.jdbcBook = jdbcBook;
    }
    public void save(Article articles) {
        jdbcBook.save(articles);
    }


    public Article getAeticle(int articleId) {
        return jdbcBook.getArticle(articleId);
    }


}
