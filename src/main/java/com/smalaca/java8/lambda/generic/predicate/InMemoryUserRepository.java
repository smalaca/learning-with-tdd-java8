package com.smalaca.java8.lambda.generic.predicate;

import com.smalaca.java8.lambda.generic.predicate.domain.Login;
import com.smalaca.java8.lambda.generic.predicate.domain.Name;
import com.smalaca.java8.lambda.generic.predicate.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class InMemoryUserRepository {
    private final List<User> users = new ArrayList<>();

    boolean exist(User user) {
        return users.contains(user);
    }

    public void add(User user) {
        users.add(user);
    }

    User findBy(Login login) {
        for (User user : users) {
            if (user.hasLoginEqualTo(login)) {
                return user;
            }
        }

        throw new NotExistingUserException();
    }

    User findBy(Name name) {
        for (User user : users) {
            if (user.hasNameEqualTo(name)) {
                return user;
            }
        }

        throw new NotExistingUserException();
    }

    public User findBy(Predicate<User> predicate) {
        for (User user : users) {
            if (predicate.test(user)) {
                return user;
            }
        }

        throw new NotExistingUserException();
    }

    public User findUserBy(Function<List<User>, User> function) {
        return function.apply(users);
    }
}
