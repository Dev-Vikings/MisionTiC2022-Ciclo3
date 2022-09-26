package com.backend.DEVikings.service;

import com.backend.DEVikings.model.User;
import com.backend.DEVikings.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(Map<String, Object> dataUser){
        String email=(String) dataUser.get("email");
        User user=userRepository.findByEmail((String) dataUser.get("email"));
        if(user==null){
            String name=(String) dataUser.get("nickname");
            String image=(String) dataUser.get("picture");
            String authid=(String) dataUser.get("sub");
            User newUser=new User(email,image,authid,name);
            userRepository.save(newUser);
        }
        return user;
    }
}