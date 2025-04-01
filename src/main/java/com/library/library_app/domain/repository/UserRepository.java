package com.library.library_app.domain.repository;

import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import org.springframework.hateoas.PagedModel;

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

    /**
     * Get Users
     *
     * @param filter the filter
     * @return the users
     */
    PagedModel<UserModel> getUsers(UserModelFilter filter);

    /**
     * Delete user
     * @param id the id
     * @return the confirmation
     */
    int deleteUser(Integer id);

    /**
     * Update user
     * @param model the model
     * @return the model
     */
    UserModel updateUser(UserModel model);

    /**
     * Find user by id
     * @param id the id
     * @return the user
     */
    UserModel findById(Integer id);

    /**
     * Find user by dni
     * @param dni the dni
     * @return the user
     */
    UserModel findByDni(String dni);
}
