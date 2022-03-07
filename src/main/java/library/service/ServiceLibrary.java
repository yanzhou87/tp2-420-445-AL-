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

//    public void createExemplairesOfBook(List<Article> articles, int nb, String name) {
//        for(Article a : articles){
//                if(a.getTitle().equals(name)){
//                    for(int i = 0 ; i < nb; i++){
//                        ExemplaireBook exemplaireBook = new ExemplaireBook();
//                        exemplaireBook.setBook((Book) a);
//                        libraryDao.saveExemplaire(exemplaireBook);
//                }
//            }
//        }
//    }

    public void createLibrary(String name) {
        Library library = Library.builder()
                .name(name)
                .build();
        libraryDao.saveLibrary(library);
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

        List<Article> articles = findByNameArticle(nameArticle);

            for(Article article : articles) {
                if (article.getTitle().equals(nameArticle) && !article.isBorrowed()) {

                    Emprunt emprunt = Emprunt.builder()
                            .client(client)
                            .library(library)
                            .article(article)
                            .date(date)
                            .build();
                    libraryDao.updateIsBorrowde(article);
                    libraryDao.saveEmprunt(emprunt);

                    }

                }
            }

    public List<Emprunt> findByNameOfClientEmprunt(long userId) {
        return libraryDao.findByNameOfClientEmprunt(userId);
    }

    public void returnEmprunts(String firstName, long id,  String articleName) {
        libraryDao.returnEmprunts(firstName,id,articleName);

    }
}

