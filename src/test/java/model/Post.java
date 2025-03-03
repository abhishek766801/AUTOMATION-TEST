package model;

public class Post {
    private int userId;
    private Integer id;
    private String title;
    private String body;
 
    // Default constructor
    public Post() {}
 
    // Parameterized constructor
    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
 
    // Getters and Setters
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getBody() {
        return body;
    }
 
    public void setBody(String body) {
        this.body = body;
    }
}