package library.service;

import library.model.Article;
import library.model.Client;
import library.model.User;
import library.persistence.LibraryDAO;
import library.persistence.UserDao;
import library.persistence.UserDaoJpa;

public class ServiceLibrary {
    private LibraryDAO jdbcBook;
    private UserDaoJpa userDao;

    public ServiceLibrary(LibraryDAO jdbcBook, UserDaoJpa userDao){
        this.jdbcBook = jdbcBook;
        this.userDao = userDao;
    }
    public void save(Article articles) {
        jdbcBook.save(articles);
    }


    public Article getAeticle(int articleId) {
        return jdbcBook.getArticle(articleId);
    }


    public void createClient(String firstName, String lastName) {
       User client = Client.builder()
               .firstName(firstName)
               .lastName(lastName)
               .build();
       userDao.save(client);
    }
}
