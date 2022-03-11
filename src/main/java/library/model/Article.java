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
    @GeneratedValue(generator = "article_seq")
    protected long id;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    protected Library library;

    protected String title;
    protected String author;
    protected String yearPublication;
    protected String typeArticle;
    protected boolean isBorrowed = false;


}
