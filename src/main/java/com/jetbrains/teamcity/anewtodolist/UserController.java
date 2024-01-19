
package com.jetbrains.teamcity.anewtodolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class UserController {

    public List<User> users = new CopyOnWriteArrayList<>(Arrays.asList(new User("Marco")));

    public static final class User {
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @GetMapping("/users")
    public List<User> users() {
        return users;
    }


}
