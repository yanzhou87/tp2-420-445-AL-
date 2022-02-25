package library.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private static List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    @ToString.Exclude
    private static List<LibraryUser> users = new ArrayList<>();

    public void addBook(Article article){
        articles.add(article);
    }

}
