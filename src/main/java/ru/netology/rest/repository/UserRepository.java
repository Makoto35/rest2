package ru.netology.rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.rest.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    // Хранилище пользователей: логин -> (пароль, разрешения)
    private final Map<String, UserData> users = new HashMap<>();

    public UserRepository() {
        // Инициализация тестовых пользователей
        initUsers();
    }

    private void initUsers() {
        // Пользователь admin с паролем qwerty
        users.put("admin", new UserData(
                "qwerty",
                Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));

        // Пользователь user с паролем 12345
        users.put("user", new UserData(
                "12345",
                Collections.singletonList(Authorities.READ)));

    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        UserData userData = users.get(user);
        if (userData != null && userData.getPassword().equals(password)) {
            return userData.getAuthorities();
        }
        return Collections.emptyList();
    }

    // Внутренний класс для хранения данных пользователя
    private static class UserData {
        private final String password;
        private final List<Authorities> authorities;

        public UserData(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }

        public String getPassword() {
            return password;
        }

        public List<Authorities> getAuthorities() {
            return authorities;
        }
    }
}