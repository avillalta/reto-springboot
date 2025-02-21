package com.villalta.turismoapi.controller.user;

import com.villalta.turismoapi.model.user.Role;
import com.villalta.turismoapi.model.user.User;
import com.villalta.turismoapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Crear un nuevo usuario (público)
    @PostMapping("/register")
    public User createUser(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam Role role) {
        return userService.createUser(username, email, password, role);
    }

    // Obtener todos los usuarios (solo ADMIN)
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener un usuario por ID (solo ADMIN)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
