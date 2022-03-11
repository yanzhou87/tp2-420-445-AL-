package library;

import library.model.*;
import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

import java.time.LocalDateTime;
import java.util.List;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary serviceLibrary = new ServiceLibrary(new LibraryDaoJpa());

        var libraryId = serviceLibrary.createLibrary("biblioY");

        var emprunteurId = serviceLibrary.createClient("yan", "zhou", 33);

        var book1Id = serviceLibrary.createBook("book","author", "2020-11-01","roman");
        var book2Id = serviceLibrary.createBook("book1","author1","","");
        var book3Id = serviceLibrary.createBook("book2","","","");

        Library librarie = serviceLibrary.findLibraryById(libraryId);
        List<Article> articles = serviceLibrary.findByNameArticle("book");

            for(Article article : articles){
                    serviceLibrary.addArticleInLibrary(article,librarie);
            }

        System.out.println("//////////////   Find biblioY ////////////////");
        System.out.println(serviceLibrary.findByNameLibrary("biblioY"));

        System.out.println("//////////////   Find All Articles for author   ////////////////");
        System.out.println(serviceLibrary.findByNameArticle("author"));

        System.out.println("//////////////   Find Users   ////////////////");
        System.out.println(serviceLibrary.findByNameUser("yan"));

        System.out.println("//////////////   Find All User for id 1 ////////////////");
        LibraryUser client = serviceLibrary.findByIdUser(emprunteurId);
        System.out.println(client);

        System.out.println("//////////////   Find All Emprunt for client name  ////////////////");
        LocalDateTime date = LocalDateTime.now();
        serviceLibrary.createEmprunt((Client) client, librarie, "book", date);
        System.out.println(serviceLibrary.findByNameOfClientEmprunt(client.getId()));

        System.out.println("//////////////   After borrowing  ////////////////");
        System.out.println(serviceLibrary.findByNameArticle("book"));

        System.out.println("//////////////   return emprunt  ////////////////");
        serviceLibrary.returnEmprunts(client.getFirstName(), client.getId(), "book");
        System.out.println(serviceLibrary.findByNameOfClientEmprunt(client.getId()));

    }
}
