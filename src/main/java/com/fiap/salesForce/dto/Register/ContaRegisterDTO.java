package com.fiap.salesForce.dto.Register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaRegisterDTO {
    @Email(message = "Email inválido")
    @NotBlank(message = "Email não pode ser vazio")
    private String email;
    @NotBlank(message = "Senha não pode ser vazia")
    private String senha;
}
