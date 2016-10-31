package com.ironyard.controller;

import com.ironyard.dto.Commentz;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 10/27/16.
 */
@Controller
public class CommentJSPController {


    @RequestMapping(value = "/comment/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "filter", required = false) String filter,
                       Map<String, Object> model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Commentz[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/comments",
                HttpMethod.GET, entity, Commentz[].class);
        Commentz[] commentz = respEntity.getBody();
        List<Commentz> foundAllList = Arrays.asList(commentz);


        if (commentz != null && commentz.length > 0) {

            List<Commentz> foundAllComments = Arrays.asList(commentz);
            if (filter != null) {
                // filter the list
                for (Commentz aComment : foundAllComments) {
                    if (aComment.getName().startsWith(filter)) {
                        foundAllList.add(aComment);
                    }
                }
            } else {
                // just return all
                foundAllList = foundAllComments;
            }
        }
            model.put("comment", foundAllList);
        return "sheet_list";
    }
}

