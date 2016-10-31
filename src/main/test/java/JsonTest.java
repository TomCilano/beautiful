import com.ironyard.dto.Commentz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Tom on 10/26/16.
 */
public class JsonTest {
    private static final Logger log = LoggerFactory.getLogger(JsonTest.class);


    public static void main (String[] args){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Commentz[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/comments",
                HttpMethod.GET, entity, Commentz[].class);
        Commentz[] commentz = respEntity.getBody();
    }
}
