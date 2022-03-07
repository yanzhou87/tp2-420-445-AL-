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
@DiscriminatorValue("CD")
public class CD extends Article{

    private double durationMovie;

    @Override
    public String toString() {
        return "CD{" +
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
