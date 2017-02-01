package com.smalaca.java8.lambda.generic.predicate.domain;

public class Login {
    private final String login;

    public Login(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login1 = (Login) o;

        return login.equals(login1.login);

    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
