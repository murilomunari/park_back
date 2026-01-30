package com.mbissiato.demo_park_api.Service;

import com.mbissiato.demo_park_api.DTO.UserRequest;
import com.mbissiato.demo_park_api.Entity.User;
import com.mbissiato.demo_park_api.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(UserRequest data) {

        if (userRepository.existsByUsername(data.username())){
            throw new RuntimeException("email ja cadastrado!");
        }

        User users = User.builder()
                .username(data.username())
                .password(data.password())
                .role(data.role())
                .build();

        return userRepository.save(users);
    }

    @Transactional(readOnly = true)
    public User findById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("usuario não encontrado!"));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
