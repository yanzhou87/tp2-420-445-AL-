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

        Library librarie = library.findByNameLibrary("biblioY");
        List<Article> articles = library.findByNameArticle("book");

            for(Article article : articles){
                    library.addArticleInLibrary(article,librarie);
            }

        List<Article> articles1 = library.findByNameArticle("book");
        library.createExemplairesOfBook(articles1, 5, "book");

        System.out.println("//////////////   Find Exemplaires  ////////////////");
        System.out.println(library.findByNameArticleExemplaires("book"));
        System.out.println(library.isValidForExemplaire("book"));

        System.out.println("//////////////   Find Article  ////////////////");
        System.out.println(library.findByNameArticle("book1"));
        System.out.println(library.findByNameArticle("book"));
//////////////////////
        System.out.println("//////////////   Find Users   ////////////////");
        System.out.println(library.findByNameUser("yan"));
        System.out.println(library.findByNameUser("shasha"));

        System.out.println("//////////////   Find All Articles for title book  ////////////////");
        System.out.println(library.findByNameArticle("author"));

        System.out.println("//////////////   Find All User for id 1 ////////////////");
        LibraryUser client = library.findByIdUser(2L);
        System.out.println(client);


        System.out.println("//////////////   Find All Emprunt for client name  ////////////////");

        LocalDateTime date = LocalDateTime.now();
        library.createEmprunt((Client) client, librarie, "book", date);

        List<Emprunt> emprunts = library.findByNameOfClientEmprunt("yan");
        for(Emprunt e : emprunts){
            System.out.println(e.getDate().getDayOfWeek());
        }
        System.out.println(library.findByNameOfClientEmprunt("yan"));
        System.out.println(library.findByNameLibrary("book"));

        library.returnEmprunts("yan", 2, "book");//返回一个借，要删除一个emprunt,增加一个exemplaire,如果是书期限超过3周就要创建一个amende
    }
}
