package com.emirsanchez.encuestabackend.validators;

import com.emirsanchez.encuestabackend.annotations.UniqueEmail;
import com.emirsanchez.encuestabackend.entities.UserEntity;
import com.emirsanchez.encuestabackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    IUserRepository repo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        UserEntity user = repo.findByEmail(value);

        if (user == null) {

            return true;

        }

        return false;
    }


}
