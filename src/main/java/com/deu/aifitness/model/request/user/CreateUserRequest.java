package com.deu.aifitness.model.request.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    private Integer id;

    private String name;

    private String username;

    private Date birthday;

    private String phoneNumber;

}
