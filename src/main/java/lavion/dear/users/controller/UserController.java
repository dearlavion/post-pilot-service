package lavion.dear.users.controller;

import lavion.dear.users.dto.UserRequest;
import lavion.dear.users.dto.UserResponse;
import lavion.dear.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest) {
        UserResponse response = service.createUser(userRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getUserName())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable String userName,
            @RequestBody @Valid UserRequest userRequest) {
        return service.updateUser(userName, userRequest)
                .map(resp -> ResponseEntity.ok(resp))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> responseList = service.getAllUsers();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String username) {
        return service.getUser(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable String username) {
        return service.deleteUser(username)
                .map(resp -> ResponseEntity.ok(resp))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




}
