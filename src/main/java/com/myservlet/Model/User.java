package com.myservlet.Model;

public class User implements Comparable<User>{
    String name;
    char gender;

    public User(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public int compareTo(User user) {
        return this.name.compareTo(user.getName());
    }

    public String getName(){
        return name;
    }
    
}
