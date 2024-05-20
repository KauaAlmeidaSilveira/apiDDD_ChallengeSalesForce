package com.fiap.salesForce.dto.Register;

import jakarta.validation.Valid;

public record RegisterRequestDTO(
        @Valid EnderecoRegisterDTO endereco, @Valid EmpresaRegisterDTO empresa,
        @Valid PessoaRegisterDTO pessoa, @Valid ContaRegisterDTO conta
) {}
