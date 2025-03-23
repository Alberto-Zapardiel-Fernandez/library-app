package com.library.library_app.domain.repository;

import com.library.library_app.domain.model.user.UserModel;

/**
 * User Repository
 * @author Alberto Zapardiel Fernández
*/
public interface UserRepository {

    /**
     * Create User
     * @param userModel the user
     * @return the user created
     */
    UserModel createUser(UserModel userModel);
}
