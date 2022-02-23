package library;

import library.model.Article;
import library.model.Book;
import library.model.Client;
import library.persistence.LibraryDAOH2;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {
        LibraryDAOH2.dropTable();
        LibraryDAOH2.createDatabase();

        ServiceLibrary library = new ServiceLibrary(new LibraryDAOH2());

        Article book = new Book(1,"bookA","yan1","yan","1999-09-01",300,"ROMAN", 3);
        Article book1 = new Book(2,"bookB","yan2","yan","2000-02-05",44,"MANUEL_SCOLAIRE",4);
        Article book2 = new Book(3,"bookC","yan3","yan","1782-05-23",100,"ETUDE",1);
        Article book3 = new Book(4,"bookD","yan4","yan","1932-09-18",222,"MAGAZINE",1);
        Article book4 = new Book( 5,"bookE","yan5","yan","1939-12-01",400,"NULL",2);

        library.save(book);
        library.save(book1);
        library.save(book2);
        library.save(book3);
        library.save(book4);

        Article book11 = library.getAeticle(1);
        System.out.println(book11);
        Article book12 = library.getAeticle(2);
        System.out.println(book12);
        Article book13 = library.getAeticle(3);
        System.out.println(book13);


       // library.createClient("yan");

    }
}
