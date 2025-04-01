package com.library.library_app.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Model
 * @author Alberto Zapardiel Fernández
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private int id;
    private String username;
    private String dni;
    private String email;
    private String password;
    private int role;
}
