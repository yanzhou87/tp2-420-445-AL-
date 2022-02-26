package library.service;

import library.model.*;
import library.persistence.LibraryDao;
import library.persistence.LibraryDaoJpa;

import java.time.LocalDateTime;
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
            exemplaire.addNbExemplaires();
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

    public void createEmprunt(Client client, Library library, String nameArticle,LocalDateTime date) {

        List<Article> exemplaires = findByNameArticleExemplaires(nameArticle);

        Emprunt emprunt = new Emprunt();
        for(Article e : exemplaires){
            if(e.getTitle().equals(nameArticle)){
                emprunt = Emprunt.builder()
                        .client(client)
                        .library(library)
                        .articles(e)
                        .date(date)
                        .build();
            }
        }

        libraryDao.saveEmprunt(emprunt);
    }

    private List<Article> findByNameArticleExemplaires(String nameArticle) {
        return libraryDao.findByNameArticleExemplaires(nameArticle);
    }

    public List<Emprunt> findByNameOfClientEmprunt(String userName) {
        return libraryDao.findByNameOfClientEmprunt(userName);
    }
}

