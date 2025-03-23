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
}
