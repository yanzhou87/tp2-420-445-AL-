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
        library.createClient("shasha", "SS", 90);

        library.createBook("book","author", "2020-11-01","roman");
        library.createBook("book1","author1","","");
        library.createBook("book2","","","");

        List<Article> articles1 = library.findByNameArticle("book");
        library.createExemplairesOfBook(articles1, 5, "book");

        System.out.println("//////////////   Find Exemplaires  ////////////////");
        System.out.println(library.isValidForExemplaire("book"));


        List<Library> libraries = library.findByNameLibrary("biblioY");
        List<Article> articles = library.findByNameArticle("book");

        for(Library library1 : libraries){
            for(Article article : articles){
                if(article instanceof Book || article instanceof Exemplaire){
                    library.addArticleInLibrary(article,library1);
                }
            }
        }

        System.out.println("//////////////   Find Article  ////////////////");
        System.out.println(library.findByNameArticle("book1"));
        System.out.println(library.findByNameArticle("book"));

        System.out.println("//////////////   Find Users   ////////////////");
        System.out.println(library.findByNameUser("yan"));
        System.out.println(library.findByNameUser("shasha"));

        System.out.println("//////////////   Find All Articles for title book  ////////////////");
        System.out.println(library.findByNameArticle("author"));

        List<LibraryUser> clients = library.findByIdUser(1L);


        List<Library> libraryList = library.findByNameLibrary("biblioY");
        LocalDateTime date = LocalDateTime.now();
        System.out.println("//////////////   Find All Emprunt for client name  ////////////////");
        library.createEmprunt((Client) clients.get(0), libraryList.get(0), "book", date);

        List<Emprunt> emprunts = library.findByNameOfClientEmprunt("yan");
        for(Emprunt e : emprunts){
            System.out.println(e.getDate().getDayOfWeek());
        }
        System.out.println(library.findByNameOfClientEmprunt("yan"));
    }
}
