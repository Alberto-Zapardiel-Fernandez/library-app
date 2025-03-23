package com.library.library_app.application.service;

import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import org.springframework.hateoas.PagedModel;

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

    /**
     * Get Users
     *
     * @param filter the filter
     * @return the users
     */
    PagedModel<UserModel> getUsers(UserModelFilter filter);

    /**
     * Delete User
     * @param id the user id
     * @return the confirmation
     */
    int deleteUser(Integer id);

    /**
     * Update User
     * @param model the user
     * @return the user updated
     */
    UserModel updateUser(UserModel model);
}
