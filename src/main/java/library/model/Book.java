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
@DiscriminatorValue("book")
public class Book extends Article {

    private String editor;
    private int numbrePages;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", typeArticle='" + typeArticle + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", editor='" + editor + '\'' +
                ", numbrePages=" + numbrePages +
                '}';
    }
}
