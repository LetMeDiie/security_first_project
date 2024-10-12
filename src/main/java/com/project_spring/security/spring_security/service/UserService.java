package com.project_spring.security.spring_security.service;

import com.project_spring.security.spring_security.entity.Role;
import com.project_spring.security.spring_security.entity.User;
import com.project_spring.security.spring_security.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if(user==null) {
            throw new UsernameNotFoundException(String.format("User %s not found!",username));
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.
                withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities(mapRolesToAuthorities(user.getRoles()))
                .build();
        return userDetails;
    }

    private User findByUserName(String username){
        return userRepository.findByUserName(username);
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(r->new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
