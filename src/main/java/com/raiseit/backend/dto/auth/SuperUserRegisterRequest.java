package com.raiseit.backend.dto.auth;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Tag(
        name = "SuperUserRegisterRequest",
        description = "A superuser can create any user at first without JWT auth." + "(can be Governer, or nay higher entity we decide)"
)
public class SuperUserRegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNo;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Role is required")
    private String role;
}
