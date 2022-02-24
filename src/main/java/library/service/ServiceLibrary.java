package library.service;

import library.model.Article;
import library.model.Client;
import library.model.LibraryUser;
import library.persistence.LibraryDAO;
import library.persistence.UserDao;

import java.util.List;

public class ServiceLibrary {
    private LibraryDAO jdbcBook;
    private UserDao userDao;

    public ServiceLibrary(LibraryDAO jdbcBook, UserDao userDao){
        this.jdbcBook = jdbcBook;
        this.userDao = userDao;
    }
    public void save(Article articles) {
        jdbcBook.save(articles);
    }


    public Article getAeticle(int articleId) {
        return jdbcBook.getArticle(articleId);
    }


    public void createClient(String firstName, String lastName, int age) {
        LibraryUser client = new Client();
//       User client = Client.builder()
//                       .firstName(firstName)
//                               .lastName(lastName)
     client.setFirstName(firstName);
     client.setLastName(lastName);
     client.setAge(age);
       userDao.save(client);
    }

    public List<LibraryUser> findByName(String firstName){
        return userDao.findByName(firstName);

    }
}
