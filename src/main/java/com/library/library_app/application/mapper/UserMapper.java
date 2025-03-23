package com.library.library_app.application.mapper;

import com.library.application.controller.dto.UserDTO;
import com.library.library_app.domain.model.user.UserModel;
import org.mapstruct.Mapper;

/**
 * User Mapper
 * @author Alberto Zapardiel Fernández
*/
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Convert UserDTO to UserModel
     * @param model the model
     * @return the dto
     */
    UserDTO userModelToDTO(UserModel model);

    /**
     * Convert UserModel to UserDTO
     * @param dto the dto
     * @return the model
     */
    UserModel userDTOTOModel(UserDTO dto);
}
