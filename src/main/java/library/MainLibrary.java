package library;

import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createLibrary("biblioY");
        library.createClient("yan", "zhou", 33);


        library.createClient("shasha", "SS", 90);

        library.createBook("book");
        library.createBook("book1");
        library.createBook("book2");


        System.out.println("//////////////   Find Article  ////////////////");
        System.out.println(library.findByNameArticle("book1"));
        System.out.println(library.findByNameArticle("book"));

        library.createExemplairesOfBook("book", 5);

        System.out.println("//////////////   Find Users   ////////////////");
        System.out.println(library.findByNameUser("yan"));
        System.out.println(library.findByNameUser("shasha"));

        System.out.println("//////////////   Find All Articles for title book  ////////////////");
        System.out.println(library.findByNameArticle("book"));


    }
}
