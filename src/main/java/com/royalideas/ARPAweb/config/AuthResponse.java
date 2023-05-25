package com.royalideas.ARPAweb.config;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mis_p
 */
@Getter
@Setter
public class AuthResponse {

    private String email;
    private String accessToken;

    public AuthResponse() {
    }

    public AuthResponse(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }
}
