package DELETE;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseAPI;

import java.io.IOException;

import static utils.Endpoints.baseUrl;

public class DeleteApiTest extends BaseAPI
{

    //Payloads
    String requestBody = "{ \"title\": \"Viren\", \"body\": \"Test\", \"userId\": 1 }";

    @Test(description = "POST API Call")
    public void testPOSTapi()  throws IOException {
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
    }

    @Test(description = "Delete API Call")
    public void testDeleteAPI()
    {
        restTemplate.delete(baseUrl+"/1");
    }

    @Test(description = "Verify Deleted data by userid")
    public void testGetAPI()
    {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl+"/1", String.class);
        Assert.assertEquals(response.getStatusCodeValue(),200);
        System.out.println("Response"+response.toString());
    }

}
