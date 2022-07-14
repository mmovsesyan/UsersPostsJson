package com.movsisyan.program;

import com.movsisyan.model.Post;
import com.movsisyan.repository.PostsRepository;
import com.movsisyan.repository.UserRepository;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /*try {
            UserRepository repository = new UserRepository();
            repository.toJson("https://jsonplaceholder.typicode.com/users");
            System.out.println(repository);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/

        try {
            PostsRepository repository = new PostsRepository("https://jsonplaceholder.typicode.com/posts","https://jsonplaceholder.typicode.com/users");
            System.out.println(repository);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
