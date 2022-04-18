package com.emirsanchez.encuestabackend.models.responses;

import lombok.Data;

@Data
public class UserResponseRest {

    private long id;

    private String name;

    private String email;

}
