package com.emirsanchez.encuestabackend.controller;

import com.emirsanchez.encuestabackend.entities.UserEntity;
import com.emirsanchez.encuestabackend.models.request.UserRegistrerRequestModel;
import com.emirsanchez.encuestabackend.models.responses.UserResponseRest;
import com.emirsanchez.encuestabackend.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/crear")
    public UserResponseRest createUser(@RequestBody @Valid UserRegistrerRequestModel userModel) {

        UserEntity userEntity = service.createUser(userModel);

        UserResponseRest userReq = new UserResponseRest();

        BeanUtils.copyProperties(userEntity, userReq);

        return userReq;
    }

}
