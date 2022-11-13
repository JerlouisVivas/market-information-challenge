package com.challenge.stock.market.service;

import com.challenge.stock.market.dto.SignUpIn;
import com.challenge.stock.market.dto.SignUpOut;

public interface LoginService {
    SignUpOut registerUser(SignUpIn user);

}
