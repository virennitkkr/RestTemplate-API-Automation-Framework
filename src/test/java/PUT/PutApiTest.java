package PUT;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseAPI;

import static utils.Endpoints.baseUrl;


public class PutApiTest  extends BaseAPI {

    @Test(description = "PUT API Test cases")
    public void TestPUTapi()
    {
        String requestBody =  "{ \"title\": \"Viren\", \"body\": \"Only for Testing\", \"userId\": 1 }";

        //Set Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Create HttpEntity object with body and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        //Send POST Request
        ResponseEntity<String> response  =  restTemplate.postForEntity(baseUrl,requestBody,String.class);

        //Verify the Assertion

        Assert.assertEquals(response.getStatusCodeValue(),201);
        Assert.assertNotNull(response);
        System.out.println("Response Body: " + response);

    }
}
