package com.example.demo.controller;
import com.example.demo.model.Candidate;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @DeleteMapping(value = "{userId}")
    public void deleteUserById (@PathVariable(value = "userId") Long userId){
        userService.deleteUserById(userId);
    }
    @PutMapping(value="{userId}")
    public User updateUserById(@PathVariable(value = "userId") Long userId, @RequestBody User userDetails) {
        return userService.updateUserById(userId, userDetails);
    }
    @PostMapping(value="{userId}/candidate")
    public Candidate createUserCandidate(@RequestBody Candidate candidate, @PathVariable(value = "userId") Long userId) {
        return userService.createUserCandidate(candidate, userId);
    }
}