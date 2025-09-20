package com.yamato.authjava.controllers;

import com.yamato.authjava.http.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private ResponseEntity<ErrorResponse> notImplemented() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(ErrorResponse.of("NOT_IMPLEMENTED", "This endpoint is not implemented yet."));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register() { return notImplemented(); }

    @PostMapping("/login")
    public ResponseEntity<?> login() { return notImplemented(); }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh() { return notImplemented(); }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() { return notImplemented(); }

    @GetMapping("/session")
    public ResponseEntity<?> session() { return notImplemented(); }

    @GetMapping("/oauth/{provider}")
    public ResponseEntity<?> oauthStart(@PathVariable String provider) { return notImplemented(); }

    @GetMapping("/oauth/{provider}/callback")
    public ResponseEntity<?> oauthCallback(@PathVariable String provider) { return notImplemented(); }

    @PostMapping("/mfa/webauthn/begin")
    public ResponseEntity<?> webauthnBegin() { return notImplemented(); }

    @PostMapping("/mfa/webauthn/finish")
    public ResponseEntity<?> webauthnFinish() { return notImplemented(); }

    @PostMapping("/magic-link")
    public ResponseEntity<?> magicLink() { return notImplemented(); }

    @PostMapping("/magic-link/consume")
    public ResponseEntity<?> magicLinkConsume() { return notImplemented(); }

    @GetMapping("/oidc/.well-known/jwks.json")
    public ResponseEntity<?> jwks() { return notImplemented(); }
}
