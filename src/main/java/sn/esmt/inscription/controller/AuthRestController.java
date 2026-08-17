package sn.esmt.inscription.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import sn.esmt.inscription.security.JwtUtil;
import sn.esmt.inscription.service.CustomUserDetailsService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthRestController(AuthenticationManager authenticationManager,
                              CustomUserDetailsService userDetailsService,
                              JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        UserDetails user = userDetailsService.loadUserByUsername(username);
        String role = user.getAuthorities().iterator().next().getAuthority();
        String token = jwtUtil.genererToken(username, role);

        return Map.of("token", token);
    }
}