package library;

import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());


        library.createClient("yan", "zhou", 33);
         System.out.println(library.findByNameUser("yan"));

        library.createBook("book");
        library.createBook("book1");
        library.createBook("book2");

        library.createExemplairesOfBook("book", 5);
        System.out.println(library.findByNameArticle("book"));


    }
}
