package com.mbissiato.demo_park_api.Controller;

import com.mbissiato.demo_park_api.DTO.UserRequest;
import com.mbissiato.demo_park_api.Entity.User;
import com.mbissiato.demo_park_api.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create (@RequestBody UserRequest data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(data));

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById (@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword (@PathVariable String id, @RequestBody User user) {
        User users = userService.editPassword(id, user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
