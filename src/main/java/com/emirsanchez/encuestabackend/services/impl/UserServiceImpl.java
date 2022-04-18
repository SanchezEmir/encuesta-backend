package com.emirsanchez.encuestabackend.services.impl;

import com.emirsanchez.encuestabackend.entities.UserEntity;
import com.emirsanchez.encuestabackend.models.request.UserRegistrerRequestModel;
import com.emirsanchez.encuestabackend.repository.IUserRepository;
import com.emirsanchez.encuestabackend.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity createUser(UserRegistrerRequestModel userReq) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userReq, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));

        return userRepo.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }


}
