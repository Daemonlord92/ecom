package org.blitmatthew.ecom.service;

import jakarta.transaction.Transactional;
import org.blitmatthew.ecom.domain.entity.Address;
import org.blitmatthew.ecom.domain.entity.UserCredential;
import org.blitmatthew.ecom.domain.entity.UserProfile;
import org.blitmatthew.ecom.dto.MessageResponse;
import org.blitmatthew.ecom.dto.PostNewUser;
import org.blitmatthew.ecom.dto.UserInfo;
import org.blitmatthew.ecom.repository.AddressRepository;
import org.blitmatthew.ecom.repository.UserCredentialRepository;
import org.blitmatthew.ecom.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserInfo addUser(PostNewUser postNewUser) {
        logger.info("Adding new user"+ postNewUser);
        UserCredential userCredential = UserCredential.builder()
                .email(postNewUser.email())
                .password(passwordEncoder.encode(postNewUser.password()))
                .build();
        UserProfile userProfile = UserProfile.builder()
                .firstName(postNewUser.firstName())
                .lastName(postNewUser.lastName())
                .deliveryInstructions(postNewUser.deliveryInstructions().orElse("Leave at front door."))
                .build();
        Address address = Address.builder()
                .street(postNewUser.streetAddress())
                .apartmentNumber(postNewUser.apartmentNumber().orElse("N/A"))
                .state(postNewUser.state())
                .city(postNewUser.city())
                .zip(postNewUser.zipcode())
                .build();
        userCredential = userCredentialRepository.save(userCredential);
        address = addressRepository.save(address);
        userProfile.setAddresses(List.of(address));
        userProfile.setUserCredential(userCredential);
        userProfile = userProfileRepository.save(userProfile);
        address.setUserProfile(userProfile);
        address = addressRepository.save(address);
        userCredential.setUserProfile(userProfile);
        userCredential = userCredentialRepository.save(userCredential);
        return new UserInfo(
                userCredential.getEmail(),
                userProfile.getFirstName(),
                userProfile.getLastName(),
                address.getStreet(),
                Optional.of(address.getApartmentNumber()),
                address.getCity(),
                address.getState(),
                address.getZip(),
                userProfile.getDeliveryInstructions()
                );
    }

    @Override
    public List<UserInfo> getAllUser() {
        List<UserProfile> userProfiles = (List<UserProfile>) userProfileRepository.findAll();
        return userProfiles.stream().map(this::toUserInfo).toList();
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

    private UserInfo toUserInfo(UserProfile userProfile) {
        UserCredential credential = userProfile.getUserCredential();
        return userProfile.getAddresses().stream()
                .map(address -> new UserInfo(
                        credential.getEmail(),
                        userProfile.getFirstName(),
                        userProfile.getLastName(),
                        address.getStreet(),
                        Optional.ofNullable(address.getApartmentNumber()),
                        address.getCity(),
                        address.getState(),
                        address.getZip(),
                        userProfile.getDeliveryInstructions()
                ))
                .findFirst()
                .orElse(null);
    }
}
