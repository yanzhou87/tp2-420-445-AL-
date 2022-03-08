package library.model;

import lombok.*;
import org.h2.engine.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "library")
    @ToString.Exclude
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private static List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "library")
    @ToString.Exclude
    private static List<LibraryUser> users = new ArrayList<>();

    public void addArticle(Article article){
        articles.add(article);
        article.setLibrary(this);
    }

    public void addUser(LibraryUser user){
        users.add(user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articles=" + articles +
                '}';
    }
}
