package com.library.library_app.infrastructure.repository;

import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import com.library.library_app.domain.repository.UserRepository;
import com.library.library_app.infrastructure.mybatis.MyBatisUserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User Repository Implementation
 * @author Alberto Zapardiel Fernández
*/
@Repository
@AllArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    /**
     * Mybatis User Mapper
     */
    private MyBatisUserMapper myBatisUserMapper;

    /**
     * Create User
     * @param userModel the user
     * @return the user created
     */
    public UserModel createUser(UserModel userModel) {
        int response = myBatisUserMapper.createUser(userModel);
        if (response == 1) {
            return userModel;
        } else {
            return null;
        }
    }

    /**
     * Get Users
     *
     * @param filter the filter
     * @return the users
     */
    @Override
    public PagedModel<UserModel> getUsers(UserModelFilter filter) {
        List<UserModel> users = myBatisUserMapper.findUsers(filter);
        return PagedModel.of(users, new PagedModel.PageMetadata(filter.getLimit(), filter.getOffset(), users.size()));
    }

    /**
     * Delete user
     *
     * @param id the id
     * @return the confirmation
     */
    @Override
    public int deleteUser(Integer id) {
        return myBatisUserMapper.deleteUser(id);
    }

    /**
     * Update user
     *
     * @param model the model
     * @return the model
     */
    @Override
    public UserModel updateUser(UserModel model) {
        int response = myBatisUserMapper.updateUser(model);
        if (response == 1) {
            return model;
        } else {
            return null;
        }
    }

    /**
     * Find user by id
     *
     * @param id the id
     * @return the user
     */
    @Override
    public UserModel findById(Integer id) {
        return myBatisUserMapper.findUserById(id);
    }

    /**
     * Find user by dni
     *
     * @param dni the dni
     * @return the user
     */
    @Override
    public UserModel findByDni(String dni) {
        return myBatisUserMapper.findUserByDni(dni);
    }
}
