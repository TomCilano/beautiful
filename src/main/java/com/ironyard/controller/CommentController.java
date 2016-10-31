package com.ironyard.controller;

import com.ironyard.dto.Commentz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tom on 10/26/16.
 */
@RestController
public class CommentController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/comment", method = RequestMethod.GET)
    public Iterable<Commentz> list(@RequestParam(value = "filter", required = false) String filter) {
        log.debug("request to list comments ");


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Commentz[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/comments",
                HttpMethod.GET, entity, Commentz[].class);
        Commentz[] commentz = respEntity.getBody();
        List<Commentz> filteredComments = new ArrayList<>();



        if (commentz != null && commentz.length > 0) {

            log.info(commentz.toString());
            List<Commentz> foundAllComments = Arrays.asList(commentz);
            if (filter != null) {
                // filter the list
                for (Commentz aComment : foundAllComments) {
                    if (aComment.getName().startsWith(filter)) {
                        filteredComments.add(aComment);
                    }
                }
            } else {
                // just return all
                filteredComments = foundAllComments;
            }
        }
        return filteredComments;

    }

}


