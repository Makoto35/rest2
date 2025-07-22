package ru.netology.rest.service;

import org.springframework.stereotype.Repository;
import ru.netology.rest.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        // Заглушка с тестовыми пользователями
        if ("admin".equals(user) && "qwerty".equals(password)) {
            List<Authorities> authorities = new ArrayList<>();
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            return authorities;
        } else if ("user".equals(user) && "12345".equals(password)) {
            return Collections.singletonList(Authorities.READ);
        }
        return Collections.emptyList();
    }
}