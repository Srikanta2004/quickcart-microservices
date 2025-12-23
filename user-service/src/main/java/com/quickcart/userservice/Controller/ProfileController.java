// src/main/java/com/quickcart/userservice/controller/ProfileController.java
package com.quickcart.userservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @GetMapping("/auth/profile")
    public ResponseEntity<String> profile(Authentication authentication) {
        // authentication.getPrincipal() will be an OAuth2User after Google login
        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
        String name  = oauthUser.getAttribute("name");
        String email = oauthUser.getAttribute("email");
        return ResponseEntity.ok("Hello " + name + " (" + email + ")");
    }
}
