package ek.osnb.demospringsecurity.security.users;

import ek.osnb.demospringsecurity.app.model.EntityAuthority;
import ek.osnb.demospringsecurity.app.model.EntityUser;
import ek.osnb.demospringsecurity.app.repository.AuthorityRepository;
import ek.osnb.demospringsecurity.app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;


public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public JpaUserDetailsService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public void createUser(UserDetails userDetails) {
        EntityUser user = new EntityUser();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        Set<EntityAuthority> authorities = new HashSet<>();

        userDetails.getAuthorities().forEach( a -> {
            var foundAuth = authorityRepository.findEntityAuthorityByName(a.getAuthority()).orElseThrow(() -> new RuntimeException("Authority not found"));
            authorities.add(foundAuth);
        });

        user.setAuthorities(authorities);

        userRepository.save(user);

    }

}
