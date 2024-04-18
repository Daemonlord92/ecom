package org.blitmatthew.ecom.dto;

import java.util.Optional;

public record UserInfo(
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
