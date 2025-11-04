package org.leanit.esercizioTre;

import java.util.Objects;

public class User{
    public String name;
    public String surname;
    public int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}