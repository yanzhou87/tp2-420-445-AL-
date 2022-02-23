package library.model;

public class Admin extends User{

    public Admin(String firstName, String lastName, int age, String address) {
        super(firstName, lastName, age, address);
    }

    public boolean isAvailable(){return false;}

    public void addArticle(){}

    public void deleteArticle(){}

    public boolean isLate(){return  false;}

    public void applyFee(){}
}
