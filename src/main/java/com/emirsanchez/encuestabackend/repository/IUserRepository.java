package com.emirsanchez.encuestabackend.repository;

import com.emirsanchez.encuestabackend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmail(String email);

}
