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

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private static List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private static List<LibraryUser> users = new ArrayList<>();

    public void addArticle(Article article){
        articles.add(article);
    }

    public void addUser(LibraryUser user){
        users.add(user);
    }
}
