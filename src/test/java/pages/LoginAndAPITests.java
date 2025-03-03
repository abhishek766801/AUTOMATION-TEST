package pages;

import api.APIHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Post;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import io.restassured.response.Response;
 
public class LoginAndAPITests extends BaseTest {
    private APIHelper apiHelper;
private static final String API_BASE_URL = "https://jsonplaceholder.typicode.com";
 
    @BeforeClass
    public void setupAPI() {
        apiHelper = new APIHelper(API_BASE_URL);
    }
 
    @Test
    public void testSuccessfulLogin() {
        driver.get(baseUrl + "/login");
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("tomsmith", "SuperSecretPassword!");
        String message = loginPage.getMessage();
        
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }
 
    @Test
    public void testGetPostAPI() {
        Response response = apiHelper.getRequest("/posts/1");
        
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("title"));
    }
 
    @Test
    public void testCreatePostAPI() {
        Post newPost = new Post(1, "Test Title", "Test Body");
        Response response = apiHelper.postRequest("/posts", newPost);
        
        Assert.assertEquals(response.getStatusCode(), 201);
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            Post createdPost = mapper.readValue(response.getBody().asString(), Post.class);
            Assert.assertEquals(createdPost.getTitle(), "Test Title");
        } catch (Exception e) {
Assert.fail("Failed to parse response: " + e.getMessage());
        }
    }
}