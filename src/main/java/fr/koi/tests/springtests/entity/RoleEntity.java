package fr.koi.tests.springtests.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "role")
@Getter
@Setter
@Accessors(chain = true)
public class RoleEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

}
