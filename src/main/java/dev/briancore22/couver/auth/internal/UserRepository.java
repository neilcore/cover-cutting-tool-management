package dev.briancore22.couver.auth.internal;

import dev.briancore22.couver.core.repository.BaseJPARepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends BaseJPARepository<User, UUID> {
    /**
     * Find a user by their email address.
     *
     * @param email the email address of the user
     * @return an Optional containing the User if found, or empty if not
     */
    Optional<User> findUserByEmail(String email);
}
