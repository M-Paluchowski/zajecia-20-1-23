package com.javastart.demo.exercises.second;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Marcin", "Paluchowski", 26));
        users.add(new User("Rafał", "XYZ", 18));
        users.add(new User("Paulina", "PO", 29));
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    public void add(User user) {
        users.add(user);
    }
}
