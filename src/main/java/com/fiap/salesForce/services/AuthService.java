package com.fiap.salesForce.services;

import com.fiap.salesForce.dto.*;
import com.fiap.salesForce.dto.Register.RegisterRequestDTO;
import com.fiap.salesForce.model.Conta;
import com.fiap.salesForce.repositories.ContaRepository;
import com.fiap.salesForce.security.TokenService;
import com.fiap.salesForce.services.exceptions.InvalidCredentialsException;
import com.fiap.salesForce.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    private final ContaRepository contaRepository;
    private final EnderecoService enderecoService;
    private final EmpresaService empresaService;
    private final PessoaService pessoaService;
    private final ContaService contaService;

    @Transactional
    public ResponseDTO login(LoginRequestDTO body) {
        Conta conta = this.contaRepository.findByEmail(body.email()).orElseThrow(() -> new ResourceNotFoundException("Email não encontrado"));

        if(!passwordEncoder.matches(body.senha(), conta.getSenha())){
            throw new InvalidCredentialsException("Senha inválida");
        }

        String token = this.tokenService.generateToken(conta);
        conta.setUltimoAcesso(LocalDateTime.now());
        this.contaRepository.save(conta);
        return new ResponseDTO(conta.getUsuario(), token);
    }

    @Transactional
    public ResponseDTO register(RegisterRequestDTO body) {
        EnderecoDTO enderecoDTO = enderecoService.insert(body.endereco());
        EmpresaDTO empresaDTO = empresaService.insert(body.empresa());
        PessoaDTO pessoaDTO = pessoaService.insert(body.pessoa(), enderecoDTO, empresaDTO);

        Conta conta = new Conta();
        if (pessoaDTO.getId_pessoa() != null) {
            contaService.insert(body.conta(), pessoaDTO, conta);
        }

        String token = this.tokenService.generateToken(conta);
        return new ResponseDTO(conta.getUsuario(), token);
    }

}
