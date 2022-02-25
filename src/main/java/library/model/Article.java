package library.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "ARTICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Article_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    @OneToMany(mappedBy = "article")
    private List<Exemplaire> exemplaires = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
    public Article(String title) {
        this.title = title;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public void addExemplaires(Exemplaire exemplaire){
        exemplaires.add(exemplaire);
    }

    public int getExemplaireSize(){
        if(exemplaires.isEmpty()){
            return 0;
        }
        return exemplaires.size();

    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
            //    ", exemplaires=" + exemplaires +
                '}';
    }
}
