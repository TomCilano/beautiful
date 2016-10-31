package com.ironyard.dto;

/**
 * Created by Tom on 10/26/16.
 * "postId": 1,
 * "id": 2,
 * "name": "quo vero reiciendis velit similique earum",
 * "email": "Jayne_Kuhic@sydney.com",
 * "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati
 */
public class Commentz {
    private String postId;
    private long id;
    private String name;
    private String email;
    private String body;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
