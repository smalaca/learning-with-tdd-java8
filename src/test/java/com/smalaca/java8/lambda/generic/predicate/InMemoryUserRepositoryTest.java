package com.smalaca.java8.lambda.generic.predicate;

import com.smalaca.java8.lambda.generic.predicate.domain.Login;
import com.smalaca.java8.lambda.generic.predicate.domain.Name;
import com.smalaca.java8.lambda.generic.predicate.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryUserRepositoryTest {
    private static final Login LOGIN = new Login("smalaca");
    private static final Name NAME = new Name("Sebastian", "Malaca");
    private static final User SEBASTIAN_MALACA = new User(LOGIN, NAME);
    private static final User OTHER_USER = new User(new Login("spiderman"), new Name("Peter", "Parker"));

    private InMemoryUserRepository repository = new InMemoryUserRepository();

    @Test
    public void shouldRecognizeThatUserDoesNotExist() {
        boolean result = repository.exist(SEBASTIAN_MALACA);

        assertThat(result).isFalse();
    }

    @Test
    public void shouldRecognizeExistingUserByLogin() {
        repository.add(SEBASTIAN_MALACA);

        boolean result = repository.exist(SEBASTIAN_MALACA);

        assertThat(result).isTrue();
    }

    @Test(expected = NotExistingUserException.class)
    public void shouldThrowExceptionWhenLookingByLoginForNotExistingUser() {
        repository.findBy(LOGIN);
    }

    @Test
    public void shouldFindExistingUserByLogin() {
        repository.add(SEBASTIAN_MALACA);
        repository.add(OTHER_USER);

        User result = repository.findBy(LOGIN);

        assertThat(result).isSameAs(SEBASTIAN_MALACA);
    }

    @Test(expected = NotExistingUserException.class)
    public void shouldThrowExceptionWhenLookingByNameForNotExistingUser() {
        repository.findBy(NAME);
    }

    @Test
    public void shouldFindExistingUserByName() {
        repository.add(SEBASTIAN_MALACA);
        repository.add(OTHER_USER);

        User result = repository.findBy(NAME);

        assertThat(result).isSameAs(SEBASTIAN_MALACA);
    }
}