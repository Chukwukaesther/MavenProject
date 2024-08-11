package com.semicolon.africa.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
public class Rider {

    @Id
    private String id;
    private String riderUserName;
    private String riderPassword;
    private String riderEmail;
    private String riderPhoneNumber;
    private String riderAddress;
    private boolean isLoggedIn;

}
