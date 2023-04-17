package com.posmosalimos.geulgwi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    Long userNumber;
    String userId;
    String userPassword;
    String userName;
    String userAge;
    String userGender;
    String userAddress;
    String role;

}