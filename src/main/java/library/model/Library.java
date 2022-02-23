package library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int id;
    private String name;
    private List<Article> articles = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Library(List<Article> articles, List<User> users) {
        this.articles = articles;
        this.users = users;
    }

    public Library() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public void addUser(User user){
        users.add(user);
    }
}
