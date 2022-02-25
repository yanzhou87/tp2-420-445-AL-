package library.service;

import library.model.Article;
import library.model.Book;
import library.model.Client;
import library.model.LibraryUser;
import library.persistence.LibraryDao;

import java.util.List;

public class ServiceLibrary {
    private LibraryDao libraryDao;

    public ServiceLibrary(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public void createClient(String firstName, String lastName, int age) {
        LibraryUser client = new Client();
//       User client = Client.builder()
//                       .firstName(firstName)
//                               .lastName(lastName)
     client.setFirstName(firstName);
     client.setLastName(lastName);
     client.setAge(age);
       libraryDao.saveUser(client);
    }

    public List<LibraryUser> findByNameUser(String firstName){
        return libraryDao.findByNameUser(firstName);
    }

    public void createBook(String title) {
        Article book = new Book();
        book.setTitle(title);

        libraryDao.saveArticle(book);
    }
    

}
