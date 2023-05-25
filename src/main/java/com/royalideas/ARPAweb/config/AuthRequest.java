package com.royalideas.ARPAweb.config;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mis_p
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthRequest {

    @NotBlank(message = "ingrese un email valido")
    @Email
    private String email;

    @NotBlank(message = "ingrese una contraseña valida")
    private String password;
}
