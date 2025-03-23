package com.library.library_app.domain.service;

import com.library.library_app.application.service.UserService;
import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import com.library.library_app.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

/**
 * User Service Implementation
 * @author Alberto Zapardiel Fernández
*/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * User repository
     */
    private UserRepository userRepository;

    /**
     * Created User
     * @param userModel the user
     * @return the user created
     */
    @Override
    public UserModel createUser(UserModel userModel) {
        return userRepository.createUser(userModel);
    }

    /**
     * Get Users
     *
     * @param filter the filter
     * @return the users
     */
    @Override
    public PagedModel<UserModel> getUsers(UserModelFilter filter) {
        return userRepository.getUsers(filter);
    }

    /**
     * Delete User
     *
     * @param id the user id
     * @return the confirmation
     */
    @Override
    public int deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }

    /**
     * Update User
     *
     * @param model the user
     * @return the user updated
     */
    @Override
    public UserModel updateUser(UserModel model) {
        return userRepository.updateUser(model);
    }
}
