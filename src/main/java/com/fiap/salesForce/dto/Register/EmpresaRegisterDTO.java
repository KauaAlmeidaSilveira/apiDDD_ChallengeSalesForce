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
public class EmpresaRegisterDTO {
    @NotBlank(message = "Nome da empresa não pode ser vazio")
    private String nome;
    @NotBlank(message = "Numero de funcionarios não pode ser vazio")
    private String numFuncionario;
}
