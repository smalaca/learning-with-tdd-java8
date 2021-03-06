package com.smalaca.java8.lambda;

import com.smalaca.java8.lambda.generic.predicate.InMemoryUserRepository;
import com.smalaca.java8.lambda.generic.predicate.domain.Login;
import com.smalaca.java8.lambda.generic.predicate.domain.Name;
import com.smalaca.java8.lambda.generic.predicate.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericBuildingBlocksTest {
    private static final Login LOGIN = new Login("smalaca");
    private static final Name NAME = new Name("Sebastian", "Malaca");
    private static final User SEBASTIAN_MALACA = new User(LOGIN, NAME);
    private static final User OTHER_USER = new User(new Login("spiderman"), new Name("Peter", "Parker"));

    private InMemoryUserRepository repository = new InMemoryUserRepository();

    @Before
    public void givenUsersInTheRepository() {
        repository.add(SEBASTIAN_MALACA);
        repository.add(OTHER_USER);
    }

    @Test
    public void shouldFindByLoginWithPredicateInterface() {
        User result = repository.findBy(user -> user.hasLoginEqualTo(LOGIN));

        assertThat(result).isSameAs(SEBASTIAN_MALACA);
    }

    @Test
    public void shouldFindByNameWithPredicateInterface() {
        User result = repository.findBy(user -> user.hasNameEqualTo(NAME));

        assertThat(result).isSameAs(SEBASTIAN_MALACA);
    }

    @Test
    public void shouldFindByLoginWithFunctionInterface() {
        User result = repository.findUserBy(users -> users.stream().filter(user -> user.hasLoginEqualTo(LOGIN)).findAny().get());

        assertThat(result).isSameAs(SEBASTIAN_MALACA);
    }

    @Test
    public void shouldReturnIdentificationOfTheUser() {
        String card = repository.findByLoginUserCard(LOGIN, (login, name) -> "Login: " + login + ", Name: " + name + ".");

        assertThat(card).isEqualTo("Login: smalaca, Name: Sebastian Malaca.");
    }

    @Test
    public void shouldBlockUser() {
        assertThat(repository.findBy(LOGIN).isBlocked()).isFalse();

        repository.block(LOGIN, user -> user.block());

        assertThat(repository.findBy(LOGIN).isBlocked()).isTrue();
    }

    @Test
    public void shouldCreateNullObjectUser() {
        User user = repository.create(() -> new User(new Login("guest"), new Name("Dummy", "User")));

        assertThat(user.login()).isEqualTo("guest");
        assertThat(user.name()).isEqualTo("Dummy User");
    }
}
