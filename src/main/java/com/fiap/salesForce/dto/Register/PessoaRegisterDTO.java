package com.fiap.salesForce.dto.Register;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRegisterDTO {
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "Sobrenome não pode ser vazio")
    private String sobrenome;
    @NotBlank(message = "Cargo não pode ser vazio")
    private String cargo;
}
