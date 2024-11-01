package GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseAPI;

import static utils.Endpoints.baseUrl;

public class GetApiTest extends BaseAPI {

    @Test(description = "Get API Testing")
    public void testGETapi()
    {
        // Send GET request
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl+"/1", String.class);

        // Verify status code
        Assert.assertEquals(200, response.getStatusCodeValue());

        // Verify response body
        String responseBody = response.getBody();
        Assert.assertNotNull(responseBody);
    }
}
