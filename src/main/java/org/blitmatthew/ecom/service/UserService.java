package org.blitmatthew.ecom.service;

import org.blitmatthew.ecom.dto.MessageResponse;
import org.blitmatthew.ecom.dto.PostNewUser;
import org.blitmatthew.ecom.dto.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo addUser(PostNewUser postNewUser);
    List<UserInfo> getAllUser();
    UserInfo getUserInfoById(Long id);
    UserInfo updateUserInfo(UpdateUserInfo updateUserInfo);
    MessageResponse deleteUserById(Long id);
}
