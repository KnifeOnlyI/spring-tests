package fr.koi.tests.springtests.repository;

import fr.koi.tests.springtests.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("SELECT u FROM UserEntity u WHERE (u.username = :usernameOrEmail OR u.email = :usernameOrEmail) AND u.deletedAt IS NULL")
    UserEntity findOneByUsernameOrEmailAndDeletedAtIsNull(String usernameOrEmail);
}
