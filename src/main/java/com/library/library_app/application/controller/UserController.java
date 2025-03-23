package com.library.library_app.application.controller;

import com.library.application.controller.api.UserAPI;
import com.library.application.controller.dto.UserDTO;
import com.library.library_app.application.mapper.UserMapper;
import com.library.library_app.application.service.UserService;
import com.library.library_app.domain.model.user.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author Alberto Zapardiel Fernández
 */
@RestController
@AllArgsConstructor
public class UserController implements UserAPI {

    /**
     * User mapper
     */
    private UserMapper userMapper;

    /**
     * User service
     */
    private UserService userService;

    /**
     * POST /create_user : Create a new user.
     *
     * @param userDTO (required)
     * @return The created user. (status code 201)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserModel model = userMapper.userDTOTOModel(userDTO);
        UserModel response = userService.createUser(model);
        if (response != null) {
            return new ResponseEntity<>(userMapper.userModelToDTO(response), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(userDTO, null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
