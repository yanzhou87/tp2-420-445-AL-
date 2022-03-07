package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("DVD")
public class DVD extends Article {

    private double durationMovie;

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", typeArticle='" + typeArticle + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", durationMovie=" + durationMovie +
                '}';
    }
}
