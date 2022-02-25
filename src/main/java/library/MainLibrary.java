package library;

import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {

        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createBook("book");
        System.out.println(library.findByNameArticle("book"));


        library.createClient("yan", "zhou", 33);
        System.out.print(library.findByNameUser("yan"));

    }
}
