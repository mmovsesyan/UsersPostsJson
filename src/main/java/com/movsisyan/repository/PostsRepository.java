package com.movsisyan.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movsisyan.model.Post;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PostsRepository {
    private ArrayList<Post> posts = new ArrayList<>();

    public PostsRepository(String URL, String userURL) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            this.posts = mapper.readValue(stream, new TypeReference<>() {
            });
        }

        UserRepository repository = new UserRepository(userURL);

        for (Post post : posts) {
            post.setUser(repository.getUserById(post.getUserId()));
        }
    }

    @Override
    public String toString() {
        return "PostsRepository{" +
                "posts=" + posts +
                '}';
    }
}
