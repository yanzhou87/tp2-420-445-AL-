package library.service;

import library.model.*;
import library.persistence.LibraryDao;

import java.util.List;

public class ServiceLibrary {
    private LibraryDao libraryDao;

    public ServiceLibrary(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public void createClient(String firstName, String lastName, int age) {
       LibraryUser client = new Client();
       client.setFirstName(firstName);
       client.setLastName(lastName);
       client.setAge(age);

       libraryDao.saveUser(client);
    }

    public List<LibraryUser> findByNameUser(String firstName){
        return libraryDao.findByNameUser(firstName);
    }

    public void createBook(String title, String author, String date, String type) {
        Article book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearPublication(date);
        book.setTypeArticle(type);

        libraryDao.saveArticle(book);
    }

    public List<Article> findByNameArticle(String title) {
        return libraryDao.findByNameArticle(title);
    }

    public void createExemplairesOfBook(String title, int nb) {
        for(int i = 0 ; i < nb; i++){
            Exemplaire exemplaire = new Exemplaire();
            exemplaire.setTitle(title);
            exemplaire.addExemplaires(exemplaire);
            libraryDao.saveArticle(exemplaire);
        }
    }

    public void createLibrary(String name) {
        Library library = Library.builder()
                .name(name)
                .build();
        libraryDao.saveLibrary(library);
    }

    public List<Library> findByNameLibrary(String name) {
        return libraryDao.findByNameLibrary(name);
    }

    public void addBookInLibrary(Article article, Library library1) {
        library1.addBook(article);
    }

    public  List<LibraryUser> findByIdUser(long id) {
        return libraryDao.findByIdUser(id);
    }


    public List<Article> findByIdArticle(long id) {
        return libraryDao.findByIdArticle(id);
    }
}

