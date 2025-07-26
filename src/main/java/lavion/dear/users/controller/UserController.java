package lavion.dear.users.controller;

import lavion.dear.users.dto.UserRequest;
import lavion.dear.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<String> createOrUpdateUser(@RequestBody UserRequest userRequest) {
        service.createUser(userRequest);
        return ResponseEntity.ok("User created or updated successfully");
    }
}
