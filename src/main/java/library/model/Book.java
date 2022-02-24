package library.model;

import java.util.List;

public class Book implements Article {

    private int id;
    private String title;
    private String author;
    private String editor;
    private String yearPublication;
    private int numbrePages;
    private String typeDocument;
    private int possibleQuantity;
    private List<Exemplaire> exemplaires;

    public Book(int id, String title, String author, String editor, String yearPublication, String typeDocument,int possibleQuantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.yearPublication = yearPublication;
        this.typeDocument = typeDocument;
        this.possibleQuantity = possibleQuantity;
    }

    public Book(int id, String title, String author, String editor, String yearPublication, int numbrePages, String typeDocument, int possibleQuantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.yearPublication = yearPublication;
        this.numbrePages = numbrePages;
        this.typeDocument = typeDocument;
        this.possibleQuantity = possibleQuantity;
    }



    public Book(int id, String title, String author, String typeDocument,int possibleQuantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.typeDocument = typeDocument;
        this.possibleQuantity = possibleQuantity;
    }

    public Book(int id, String title, String typeDocument,int possibleQuantity) {
        this.id = id;
        this.title = title;
        this.typeDocument = typeDocument;
        this.possibleQuantity = possibleQuantity;
    }

    public Book(){
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public String getEditor() {
        return editor;
    }
    @Override
    public String getYearPublication() {
        return yearPublication;
    }
    @Override
    public int getNumbrePages() {
        return numbrePages;
    }
    @Override
    public String getTypeBook() {
        return typeDocument;
    }

    @Override
    public double getDurationMovie() {
        return 0;
    }

    @Override
    public int getPossibleQuantity() {
        return possibleQuantity;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setNumbrePages(int numbrePages) {
        this.numbrePages = numbrePages;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public void addEcxemplaire(Exemplaire exemplaire){
        exemplaires.add(exemplaire);
    }

    public int sizeExemplaires(){
        return exemplaires.size();
    }

    @Override
    public void setPossibleQuantity(int possibleQuantity) {
        this.possibleQuantity = possibleQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", yearPublication='" + yearPublication + '\'' +
                ", numbrePages=" + numbrePages +
                ", typeDocument='" + typeDocument + '\'' +
                ", possibleQuantity=" + possibleQuantity +
                '}';
    }
}
