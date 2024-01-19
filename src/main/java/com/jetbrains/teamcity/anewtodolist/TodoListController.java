package com.jetbrains.teamcity.anewtodolist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TodoListController {


    public List<Todo> todos = new CopyOnWriteArrayList<>(Arrays.asList(new Todo("never done", false)));

    public static final class Todo {
        private String name;
        private Boolean done;

        public Todo() {
        }

        public Todo(String name, Boolean done) {
            this.name = name;
            this.done = done;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getDone() {
            return done;
        }

        public void setDone(Boolean done) {
            this.done = done;
        }
    }


    @GetMapping("/todos")
    public List<Todo> todos() {
        return todos;
    }


    @PostMapping("/todos")
    public Todo todos(@RequestBody Todo todo) {
        todos.add(todo);
        return todo;
    }



}
