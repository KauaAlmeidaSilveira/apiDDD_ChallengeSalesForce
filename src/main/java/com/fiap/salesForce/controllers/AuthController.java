package com.fiap.salesForce.controllers;

import com.fiap.salesForce.dto.*;
import com.fiap.salesForce.dto.Register.RegisterRequestDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.security.TokenService;
import com.fiap.salesForce.services.*;
import com.fiap.salesForce.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PessoaService pessoaService;
    private final ContaRepository contaRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ContaService contaService;
    private final EnderecoService enderecoService;
    private final EmpresaService empresaService;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        return ResponseEntity.ok(authService.login(body));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        return ResponseEntity.ok(authService.register(body));
    }

}
