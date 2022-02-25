package library.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "article")
public class Exemplaire extends Article{

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")

    private Article article;


}
