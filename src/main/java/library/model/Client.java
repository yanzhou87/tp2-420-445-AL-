package library.model;

public class Client extends User{

    private String query = "";

    public Client(String firstName, String lastName, int age,String address) {
        super(firstName,lastName,age,address);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void borrow(){

    }

    public void returnArticle(){

    }

    public void toPay(){}
}
