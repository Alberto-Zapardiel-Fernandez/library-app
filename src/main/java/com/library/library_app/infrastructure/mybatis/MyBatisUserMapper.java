package com.library.library_app.infrastructure.mybatis;

import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis User Mapper
 * @author Alberto Zapardiel Fernández
*/
@Repository
public interface MyBatisUserMapper {

    /**
     * Create User
     * @param userModel the user
     * @return the user created
     */
    int createUser(UserModel userModel);

    /**
     * Find All Users
     * @param filter the filter
     * @return the users
     */
    List<UserModel> findUsers(UserModelFilter filter);

    /**
     * Delete user
     *
     * @param id the id
     * @return the confirmation
     */
    int deleteUser(Integer id);

    /**
     * Update user
     *
     * @param model the model
     * @return the model
     */
    int updateUser(UserModel model);

    /**
     * Find user by id
     *
     * @param id the id
     * @return the user
     */
    UserModel findUserById(Integer id);

    /**
     * Find user by dni
     *
     * @param dni the dni
     * @return the user
     */
    UserModel findUserByDni(String dni);
}
