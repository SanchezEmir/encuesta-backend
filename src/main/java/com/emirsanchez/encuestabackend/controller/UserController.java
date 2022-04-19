package com.emirsanchez.encuestabackend.controller;

import com.emirsanchez.encuestabackend.entities.UserEntity;
import com.emirsanchez.encuestabackend.models.request.UserRegistrerRequestModel;
import com.emirsanchez.encuestabackend.models.responses.UserResponseRest;
import com.emirsanchez.encuestabackend.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/list")
    public UserResponseRest getUser(Authentication authentication) {

        String userEmail = authentication.getPrincipal().toString();

        UserEntity user = service.getUser(authentication.getPrincipal().toString());

        UserResponseRest userRes = new UserResponseRest();

        BeanUtils.copyProperties(user, userRes);

        return userRes;

    }

    @PostMapping("/create")
    public UserResponseRest createUser(@RequestBody @Valid UserRegistrerRequestModel userModel) {

        UserEntity userEntity = service.createUser(userModel);

        UserResponseRest userReq = new UserResponseRest();

        BeanUtils.copyProperties(userEntity, userReq);

        return userReq;
    }



}
