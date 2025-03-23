package com.library.library_app.infrastructure.mybatis;

import com.library.library_app.domain.model.user.UserModel;
import org.springframework.stereotype.Repository;

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
}
