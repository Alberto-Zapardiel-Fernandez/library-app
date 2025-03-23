package com.library.library_app.application.mapper;

import com.library.application.controller.dto.PagedUserListDTO;
import com.library.application.controller.dto.UserDTO;
import com.library.library_app.domain.model.user.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.List;

/**
 * User Mapper
 * @author Alberto Zapardiel Fernández
*/
@Mapper(componentModel = "spring")
public interface UserMapper extends LinksMapper{

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

    @Mapping(target = "users", qualifiedByName = "userListToDTOList", source = "content")
    @Mapping(target ="links", source = "links", qualifiedByName = "linksToLinksDTO")
    PagedUserListDTO userModelListToDTOList(PagedModel<UserModel> users);

    @Named("userListToDTOList")
    default List<UserDTO> userListToDTOList(Collection<UserModel> users) {
        return users.stream()
                .map(this::userModelToDTO)
                .toList();
    }
}
