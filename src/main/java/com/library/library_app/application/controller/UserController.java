package com.library.library_app.application.controller;

import com.library.application.controller.api.UserAPI;
import com.library.application.controller.dto.PagedUserListDTO;
import com.library.application.controller.dto.UserDTO;
import com.library.library_app.application.hateoas.PaginationLinksGenerator;
import com.library.library_app.application.hateoas.UrlBuilderImpl;
import com.library.library_app.application.mapper.UserMapper;
import com.library.library_app.application.service.UserService;
import com.library.library_app.domain.model.user.UserModel;
import com.library.library_app.domain.model.user.UserModelFilter;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    /**
     * DELETE /delete_user/{id} : Delete a user by id.
     *
     * @param id The id of the user. (required)
     * @return No content. (status code 204)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        int response = userService.deleteUser(id);
        if (response == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /search_users : Get a list of users.
     *
     * @param offset Number of items to skip. (optional, default to 0)
     * @param limit  Number of items to return. (optional, default to 10)
     * @param body   (optional)
     * @return List of books with pagination links. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<PagedUserListDTO> getUsers(Integer offset, Integer limit, UserDTO body) {
        UserModel model = userMapper.userDTOTOModel(body);
        UserModelFilter filter = new UserModelFilter(limit,offset,model);
        PagedModel<UserModel> pagedModel = userService.getUsers(filter);
        UrlBuilderImpl urlBuilder = new UrlBuilderImpl();
        Links links = PaginationLinksGenerator.generateLinks(offset, limit,
                Objects.requireNonNull(pagedModel.getMetadata()).getTotalElements(), urlBuilder);
        pagedModel.add(links);
        PagedUserListDTO response = userMapper.userModelListToDTOList(pagedModel);
        return ResponseEntity.ok(response);
    }

    /**
     * PUT /update_user : Update a user by id.
     *
     * @param userDTO (required)
     * @return The updated user data. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<UserDTO> updateUser(UserDTO userDTO) {
        UserModel model = userMapper.userDTOTOModel(userDTO);
        UserModel response = userService.updateUser(model);
        if (response != null) {
            return new ResponseEntity<>(userMapper.userModelToDTO(response), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userDTO, null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
