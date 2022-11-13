package com.challenge.stock.market.controller;

import com.challenge.stock.market.dto.MarketInformationOut;
import com.challenge.stock.market.dto.SignUpIn;
import com.challenge.stock.market.dto.SignUpOut;
import com.challenge.stock.market.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService service;
    @PostMapping("/signUp")
    public ResponseEntity<SignUpOut> createUser(@RequestBody SignUpIn user){
        logger.info("signUp controller requested");
        return  new ResponseEntity<>(service.registerUser(user),HttpStatus.CREATED);
    }
}
