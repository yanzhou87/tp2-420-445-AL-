package library;

import library.model.Article;
import library.model.Book;
import library.persistence.LibraryDaoJpa;
import library.service.ServiceLibrary;

public class MainLibrary {
    public static void main(String[] args) {
        //LibraryDAOH2.dropTable();
        //LibraryDAOH2.createDatabase();


        ServiceLibrary library = new ServiceLibrary(new LibraryDaoJpa());

        library.createArticle(article);
        library.findByNameArticle("");
        
//        Article book = new Book("bookA","yan1","yan","1999-09-01",300,"ROMAN");
//        Article book1 = new Book("bookB","yan2","yan","2000-02-05",44,"MANUEL_SCOLAIRE");
//        Article book2 = new Book("bookC","yan3","yan","1782-05-23",100,"ETUDE");
//        Article book3 = new Book("bookD","yan4","yan","1932-09-18",222,"MAGAZINE");
//        Article book4 = new Book("bookE");

//        library.saveArticle(book);
//        library.saveArticle(book1);
//        library.saveArticle(book2);
//        library.saveArticle(book3);
//        library.saveArticle(book4);


        System.out.print(library.findByNameUser("bookD"));
//        Article book11 = library.getAeticle(1);
//        System.out.println(book11);
//        Article book12 = library.getAeticle(2);
//        System.out.println(book12);
//        Article book13 = library.getAeticle(3);
//        System.out.println(book13);


        library.createClient("yan", "zhou", 33);
        System.out.print(library.findByNameUser("yan"));

    }
}
