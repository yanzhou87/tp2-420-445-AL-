package library.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ARTICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Article_type", discriminatorType = DiscriminatorType.STRING)
//@EqualsAndHashCode(exclude = "library")
public abstract class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String author;
    private String yearPublication;
    private String typeArticle;

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    @ToString.Exclude
    private static List<Exemplaire> exemplaires = new ArrayList<>();

    private static int nbExemplaires = 0 ;
    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

//
//    public Article(String title) {
//        this.title = title;
//    }
//
//    public Article() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getYearPublication() {
//        return yearPublication;
//    }
//
//    public void setYearPublication(String yearPublication) {
//        this.yearPublication = yearPublication;
//    }
//
//    public String getTypeArticle() {
//        return typeArticle;
//    }
//
//    public void setTypeArticle(String typeArticle) {
//        this.typeArticle = typeArticle;
//    }
//
//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }

    public static int getNbExemplaires() {
        return nbExemplaires;
    }

    public static void setNbExemplaires(int nbExemplaires) {
        Article.nbExemplaires = nbExemplaires;
    }

    public void addNbExemplaires(){
        nbExemplaires++;
    }
//
//
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", yearPublication='" + yearPublication + '\'' +
//                ", typeArticle='" + typeArticle + '\'' +
//                ", nombre exemplaires='" + getNbExemplaires() + '\'' +
//                ", library=" + library +
//                '}';
//    }
}
