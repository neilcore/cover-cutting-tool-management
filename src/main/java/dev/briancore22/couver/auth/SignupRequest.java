package dev.briancore22.couver.auth;

public record SignupRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role) {
    public SignupRequest {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be blank");
        }
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be blank");
        }
    }
}
