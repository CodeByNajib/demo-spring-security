package ek.osnb.demospringsecurity.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {

    @GetMapping
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<GreetingDto> home() {
        return ResponseEntity.ok(new GreetingDto("Welcome to the protected endpoint!"));
    }
}
