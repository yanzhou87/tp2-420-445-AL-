package library.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Article {

    private String author;
    private String editor;
    private String yearPublication;
    private int numbrePages;
    private String typeDocument;

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getNumbrePages() {
        return numbrePages;
    }

    public void setNumbrePages(int numbrePages) {
        this.numbrePages = numbrePages;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
           //     ", nombre exemplaires=" + getExemplaireSize() +
                "author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", numbrePages=" + numbrePages +
                ", typeDocument='" + typeDocument + '\'' +
                '}';
    }
}
