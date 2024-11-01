package POST;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.corm.mapping.Post;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.http.HttpHeaders;
import utils.BaseAPI;

import java.io.IOException;

import static utils.Endpoints.baseUrl;


public class PostApiTest extends BaseAPI {


   //Payloads

   String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

   //Headers


   @Test(description = "POST API Call")
   public void testPOSTapi()  throws IOException
   {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Type", "application/json");

      // Create HttpEntity object with body and headers
      HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

      // Send POST request
      ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, requestEntity, String.class);

      //verify status
      Assert.assertEquals(response.getStatusCodeValue(), 201);

      //verify the response body
      String responseBody = response.getBody();
      Assert.assertNotNull(responseBody);
      System.out.println("Response"+responseBody.toLowerCase());

      // Parse response body as JSON
      ObjectMapper objectMapper = new ObjectMapper();
      Post post = objectMapper.readValue(response.getBody(), Post.class);

      //Verify the Assertion

      Assert.assertEquals(post.getId(), 101);
      Assert.assertEquals(post.getBody(), "bar");
      Assert.assertEquals(post.getUserId(),1);
      Assert.assertEquals(post.getTitle(),"foo");


   }

}
