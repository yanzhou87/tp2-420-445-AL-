package library;

import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createClient("yan", "zhou", 33);
      //  System.out.print(library.findByNameUser("yan"));

        library.createBook("book");
        library.createBook("book1");
        library.createBook("book2");
      //  System.out.println(library.findByNameArticle("book"));
        library.createExemplairesOfBook("book", 5);

    }
}
