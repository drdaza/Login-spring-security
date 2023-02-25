package com.drdaza.login_spring_security.users.application.userDetailsServices;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.models.SecurityUser;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        SecurityUser user = repository.findByUsername(username)
                            .map(SecurityUser::new)
                            .orElseThrow(() -> new UsernameNotFoundException("username not found"+username));

        return user;
    }
    
}
