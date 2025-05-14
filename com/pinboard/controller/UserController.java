// UserController.java
package com.pinboard.controller;

import com.pinboard.dto.PinDTO;
import com.pinboard.dto.UserDTO;
import com.pinboard.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchUsers(@RequestParam String query) {
        return ResponseEntity.ok(userService.searchUsers(query));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/follow/{followId}")
    public ResponseEntity<UserDTO> followUser(@PathVariable Long id, @PathVariable Long followId) {
        return ResponseEntity.ok(userService.followUser(id, followId));
    }

    @DeleteMapping("/{id}/unfollow/{followId}")
    public ResponseEntity<UserDTO> unfollowUser(@PathVariable Long id, @PathVariable Long followId) {
        return ResponseEntity.ok(userService.unfollowUser(id, followId));
    }

    @GetMapping("/{id}/feed")
    public ResponseEntity<List<PinDTO>> getUserFeed(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserFeed(id));
    }

    @PostMapping("/{userId}/subscribe/{pinId}")
    public ResponseEntity<Void> subscribeToPin(@PathVariable Long userId, @PathVariable Long pinId) {
        userService.subscribeToPin(userId, pinId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/unsubscribe/{pinId}")
    public ResponseEntity<Void> unsubscribeFromPin(@PathVariable Long userId, @PathVariable Long pinId) {
        userService.unsubscribeFromPin(userId, pinId);
        return ResponseEntity.ok().build();
    }
}