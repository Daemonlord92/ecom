package org.blitmatthew.ecom.dto;

import java.util.Optional;

public record PostNewUser(
        String email,
        String password,
        String firstName,
        String lastName,
        String streetAddress,
        Optional<String> apartmentNumber,
        String city,
        String state,
        String zipcode,
        Optional<String> deliveryInstructions
) {
}
