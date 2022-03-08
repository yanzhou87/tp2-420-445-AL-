package library;

import library.model.*;
import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

import java.time.LocalDateTime;
import java.util.List;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createLibrary("biblioY");
        System.out.println(library.findByNameLibrary("biblioY"));

        library.createClient("yan", "zhou", 33);

        library.createBook("book","author", "2020-11-01","roman");
        library.createBook("book1","author1","","");
        library.createBook("book2","","","");

        Library librarie = library.findByNameLibrary("biblioY");
        List<Article> articles = library.findByNameArticle("book");

            for(Article article : articles){
                    library.addArticleInLibrary(article,librarie);
            }

        System.out.println("//////////////   Find Article  ////////////////");
        System.out.println(library.findByNameArticle("book1"));
        System.out.println(library.findByNameArticle("book"));
        System.out.println("//////////////   Find All Articles for author   ////////////////");
        System.out.println(library.findByNameArticle("author"));

        System.out.println("//////////////   Find Users   ////////////////");
        System.out.println(library.findByNameUser("yan"));

        System.out.println("//////////////   Find All User for id 1 ////////////////");
        LibraryUser client = library.findByIdUser(1L);
        System.out.println(client);

        System.out.println("//////////////   Find All Emprunt for client name  ////////////////");
        LocalDateTime date = LocalDateTime.now();
        library.createEmprunt((Client) client, librarie, "book", date);
        System.out.println(library.findByNameOfClientEmprunt(client.getId()));

        System.out.println("//////////////   After borrowing  ////////////////");
        System.out.println(library.findByNameArticle("book"));

        System.out.println("//////////////   return emprunt  ////////////////");
        library.returnEmprunts(client.getFirstName(), client.getId(), "book");
        System.out.println(library.findByNameOfClientEmprunt(client.getId()));


        System.out.println(library.findByNameLibrary("biblioY"));
    }
}
