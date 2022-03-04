package library.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ARTICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Article_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

    private String title;
    private String author;
    private String yearPublication;
    private String typeArticle;
    private boolean isBorrowed = false;


}
