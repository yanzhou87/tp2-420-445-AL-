package library.service;

import library.model.*;
import library.persistence.LibraryDao;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceLibrary {
    private LibraryDao libraryDao;

    public ServiceLibrary(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public void createClient(String firstName, String lastName, int age) {
       libraryDao.createUser(firstName,lastName,age);
    }

    public List<LibraryUser> findByNameUser(String firstName){
        return libraryDao.findByNameUser(firstName);
    }

    public void createBook(String title, String author, String date, String type) {
        libraryDao.createBook(title, author, date, type);
    }

    public List<Article> findByNameArticle(String title) {
        return libraryDao.findByNameArticle(title);
    }

    public void createLibrary(String name) {
        libraryDao.createLibrary(name);
    }

    public Library findByNameLibrary(String name) {
        return libraryDao.findByNameLibrary(name);
    }

    public void addArticleInLibrary(Article article, Library library1) {
        library1.addArticle(article);
    }

    public  LibraryUser findByIdUser(long id) {
        return libraryDao.findByIdUser(id);
    }

    public List<Article> findByIdArticle(long id) {
        return libraryDao.findByIdArticle(id);
    }

    public void createEmprunt(Client client, Library library, String nameArticle,LocalDateTime date) {
              libraryDao.createEmprunt(client, library, nameArticle, date);
    }

    public List<Emprunt> findByNameOfClientEmprunt(long userId) {
        return libraryDao.findByNameOfClientEmprunt(userId);
    }

    public void returnEmprunts(String firstName, long id,  String articleName) {
        libraryDao.returnEmprunts(firstName,id,articleName);

    }
}

