package org.blitmatthew.ecom.service;

import org.blitmatthew.ecom.dto.MessageResponse;
import org.blitmatthew.ecom.dto.PostNewUser;
import org.blitmatthew.ecom.dto.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo addUser(PostNewUser postNewUser) {
        return null;
    }

    @Override
    public List<UserInfo> getAllUser() {
        return List.of();
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        return null;
    }

    @Override
    public UserInfo updateUserInfo(UpdateUserInfo updateUserInfo) {
        return null;
    }

    @Override
    public MessageResponse deleteUserById(Long id) {
        return null;
    }
}
