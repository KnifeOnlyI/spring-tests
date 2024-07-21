package fr.koi.tests.springtests.service;

import fr.koi.tests.springtests.entity.UserEntity;
import fr.koi.tests.springtests.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsManager {

    private final UserRepository userRepository;

    @Override
    public void createUser(final UserDetails user) {
    }

    @Override
    public void updateUser(final UserDetails user) {

    }

    @Override
    public void deleteUser(final String username) {

    }

    @Override
    public void changePassword(final String oldPassword, final String newPassword) {

    }

    @Override
    public boolean userExists(final String username) {
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(final String usernameOrEmail) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findOneByUsernameOrEmailAndDeletedAtIsNull(usernameOrEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<String> roles = new HashSet<>();

        // For every role in every group of the user, add the role to the roles set
        // Because is a set, roles will be unique even if two groups contains the same role
        user.getGroups()
            .forEach((group) -> group.getRoles()
                .forEach((role) -> roles.add(StringUtils.lowerCase(role.getName())))
            );

        return new AppUserDetails(
            user.getUsername(),
            user.getPassword(),
            roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet())
        );
    }

}
