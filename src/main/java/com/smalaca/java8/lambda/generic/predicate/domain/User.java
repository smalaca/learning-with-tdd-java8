package com.smalaca.java8.lambda.generic.predicate.domain;

public class User {
    private final Login login;
    private final Name name;

    public User(Login login, Name name) {
        this.login = login;
        this.name = name;
    }

    public boolean hasLoginEqualTo(Login login) {
        return this.login.equals(login);
    }

    public boolean hasNameEqualTo(Name name) {
        return this.name.equals(name);
    }
}