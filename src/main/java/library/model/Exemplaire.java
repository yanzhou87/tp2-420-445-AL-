package library.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exemplaire extends Article{

    private int nbPossible = getExemplaireSize();

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
    public Exemplaire() {
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "id=" + getId() +
                "title=" + getTitle() +
                "nbPossible=" + nbPossible +
                '}';
    }


//    public int getNbPossible() {
//        return nbPossible;
//    }
//
//    public void setNbPossible(int nbPossible) {
//        this.nbPossible = nbPossible;
//    }
//
//    @Override
//    public String toString() {
//        return "Exemplaire{" +
//                "nbPossible=" + nbPossible +
//          //      ", article=" + article +
//                '}';
//    }
}
