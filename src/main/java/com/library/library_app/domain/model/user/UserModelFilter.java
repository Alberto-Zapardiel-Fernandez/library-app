package com.library.library_app.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Model Filter
 * @author Alberto Zapardiel Fernández
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelFilter {

    private Integer limit;
    private Integer offset;
    private UserModel userModel;
}
