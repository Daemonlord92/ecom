package org.blitmatthew.ecom.service;

import java.util.Optional;

public record UpdateUserInfo(
        String email,
        String firstName,
        String lastName,
        String streetAddress,
        Optional<String> apartmentNumber,
        String city,
        String state,
        String zipcode,
        String deliveryInstructions
) {
}
