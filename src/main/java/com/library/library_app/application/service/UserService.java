package com.library.library_app.application.service;

import com.library.library_app.domain.model.user.UserModel;

/**
 * User Service
 * @author Alberto Zapardiel Fernández
*/
public interface UserService {

    /**
     * Create User
     * @param userModel the user
     * @return the user created
     */
    UserModel createUser(UserModel userModel);
}
