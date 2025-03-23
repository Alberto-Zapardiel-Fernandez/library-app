package com.library.library_app.infrastructure.repository;

import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.repository.UserRepository;
import com.library.library_app.infrastructure.mybatis.MyBatisUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * User Repository Implementation
 * @author Alberto Zapardiel Fernández
*/
@Repository
@AllArgsConstructor
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
}
