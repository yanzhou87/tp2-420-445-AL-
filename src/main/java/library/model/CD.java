package library.model;

public class CD implements Article{

    private  int id;
    private String title;
    private double durationMovie;
    private int possibleQuantity;

    public CD() {
    }

    public CD(int id, String title, double durationMovie,int possibleQuantity) {
        this.id = id;
        this.title = title;
        this.durationMovie = durationMovie;
        this.possibleQuantity = possibleQuantity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getEditor() {
        return null;
    }

    @Override
    public String getYearPublication() {
        return null;
    }

    @Override
    public int getNumbrePages() {
        return 0;
    }

    @Override
    public String getTypeBook() {
        return null;
    }

    @Override
    public double getDurationMovie() {
        return this.durationMovie;
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

    @Override
    public void setPossibleQuantity(int possibleQuantity) {
       this.possibleQuantity = possibleQuantity;
    }

    public void setDurationMovie(double durationMovie) {
        this.durationMovie = durationMovie;
    }

    @Override
    public String toString() {
        return "CD{" +
                "title='" + title + '\'' +
                ", durationMovie=" + durationMovie + '\'' +
                ", possibleQuantity=" + possibleQuantity +
                '}';
    }
}
