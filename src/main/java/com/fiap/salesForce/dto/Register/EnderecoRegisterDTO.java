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
public class EnderecoRegisterDTO {
    @NotBlank(message = "Pais não pode ser vazia")
    private String pais;
}
