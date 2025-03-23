package com.library.library_app.domain.service;

import com.library.library_app.application.service.UserService;
import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
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
}
