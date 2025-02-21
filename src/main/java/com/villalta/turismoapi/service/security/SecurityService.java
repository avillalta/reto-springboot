package com.villalta.turismoapi.service.security;

import com.villalta.turismoapi.model.user.User;
import com.villalta.turismoapi.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    public Boolean requestValidation(String token){
        return userRepository.existsByToken(token);
    }

    public Optional<User> login(String user, String email){
        if(userRepository.existsByEmailAndUser(email, user)){
            return Optional.ofNullable( userRepository.findByEmail(email) );
        }
        else return Optional.empty();
    }
}
