package com.emirsanchez.encuestabackend.services;

import com.emirsanchez.encuestabackend.entities.UserEntity;
import com.emirsanchez.encuestabackend.models.request.UserRegistrerRequestModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService extends UserDetailsService {

    public UserEntity getUser(String email);

    public UserEntity createUser(UserRegistrerRequestModel user);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
