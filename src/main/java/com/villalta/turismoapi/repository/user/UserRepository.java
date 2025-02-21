package com.villalta.turismoapi.repository.user;

import com.villalta.turismoapi.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByToken(String token);
    Boolean existsByToken(String token);
    Boolean existsByEmailAndUser(String email, String user);
    User findByEmail(String email);

}