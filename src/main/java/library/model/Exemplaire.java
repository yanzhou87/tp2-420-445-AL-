package library.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exemplaire extends Article{

    private int nbPossible = getExemplaireSize();

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;



}
