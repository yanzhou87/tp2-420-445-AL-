package library;

import library.model.Article;
import library.model.Client;
import library.model.Library;
import library.model.LibraryUser;
import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;
import org.hibernate.type.LocalDateTimeType;

import java.time.LocalDateTime;
import java.util.List;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createLibrary("biblioY");
        System.out.println();

        library.createClient("yan", "zhou", 33);
        library.createClient("shasha", "SS", 90);

        library.createBook("book","author", "2020-11-01","roman");
        library.createBook("book1","author1","","");
        library.createBook("book2","","","");

        library.createExemplairesOfBook("book", 5);

        List<Library> libraries = library.findByNameLibrary("biblioY");
        List<Article> articles = library.findByNameArticle("book");
        for(Library library1 : libraries){
            for(Article article : articles){
                library.addBookInLibrary(article,library1);
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

        List<LibraryUser> client = library.findByIdUser(1L);
        System.out.println(client);
        List<Article> article = library.findByIdArticle(1L);
//        LocalDateTime date = LocalDateTime.now();
//        library.createEmprunt(client[], article[], date);
    }
}
