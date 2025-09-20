package com.yamato.authjava.controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/healthz")
    public ResponseEntity<Map<String, Object>> healthz() {
        return ResponseEntity.ok(Map.of("ok", true));
    }

    @GetMapping("/readyz")
    public ResponseEntity<Map<String, Object>> readyz() {
        return ResponseEntity.ok(Map.of("ready", true));
    }
}
