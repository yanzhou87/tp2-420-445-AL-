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

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
}
