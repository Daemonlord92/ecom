package org.blitmatthew.ecom.repository;

import org.blitmatthew.ecom.domain.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
}
