/*package com.ntoutakeout.backend.controller;

import com.ntoutakeout.backend.entity.Store;
import com.ntoutakeout.backend.entity.user.User;
import com.ntoutakeout.backend.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private StoreService userService;

    @GetMapping("/getUserIdByEmail")
    public ResponseEntity<?> getUserIdByEmail(@RequestParam("email") String email) {
        log.info("Fetch API: getUserIdByEmail Success");
        try {
            User user = userService.findByEmail(email);

            if (user == null) {
                log.error("User not found with email: " + email);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            log.error("Error fetching user by email: " + email, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody User user) {
        log.info("Fetch API: signup Success");
        try {
            User newUser = userService.signUpUser(user);

            String token = userService.generateToken(newUser);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Authorization", "Bearer " + token)
                    .body(newUser);
        } catch (Exception e) {
            log.error("Signup failed for user: " + user.getEmail(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Signup failed: " + e.getMessage());
        }
    }




    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        log.info("Fetch API: login Success");
        try {
            User loginUser = userService.loginUser(user);

            String token = userService.generateToken(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Authorization", "Bearer " + token)
                    .body(loginUser);
        } catch (Exception e) {
            log.error("Login failed for email: " + user.getEmail(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<User> updateUser(@RequestHeader("Authorization") String token,
                                           @RequestBody Map<String, Object> userUpdates) {
        log.info("Fetch API: update User");
        try {
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = validateToken(jwtToken);
            if (claims == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            User updatedUser = userService.updateUser(userUpdates);

            if (updatedUser == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            return ResponseEntity.ok(updatedUser);

        } catch (IllegalArgumentException e) {
            log.error("Update failed due to invalid input: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (SecurityException e) {
            log.error("Update failed due to authorization: ", e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e) {
            log.error("Unexpected error updating user: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



}*/