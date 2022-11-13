package com.challenge.stock.market.service.impl;

import com.challenge.stock.market.dto.SignUpIn;
import com.challenge.stock.market.dto.SignUpOut;
import com.challenge.stock.market.model.User;
import com.challenge.stock.market.repository.UserRepository;
import com.challenge.stock.market.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    UserRepository repository;

    private SignUpOut createUser(SignUpIn user) {
        logger.info("Login service: create user");
        User usr = new User();
        usr.setName(user.getName());
        usr.setLastName(user.getLastName());
        usr.setEmail(user.getEmail());
        usr.setApiKey(UUID.randomUUID().toString());
        repository.save(usr);
        logger.info("Login service: user created!");
        return new SignUpOut(usr.getApiKey());
    }

    @Override
    public SignUpOut registerUser(SignUpIn user) {
        logger.info("checking if the user exists");
        User response = repository.findByNameAndEmail(user.getName(), user.getEmail());
        if(response == null){
            logger.info("user not exists");
            return this.createUser(user);
        }
        logger.info("user already exists");
        return new SignUpOut(response.getApiKey());
    }

}
