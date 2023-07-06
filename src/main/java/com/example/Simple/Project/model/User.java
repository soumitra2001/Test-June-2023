package com.example.Simple.Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank
    @Pattern(regexp = "[A-Z\\da-z]+")
    private String userName;

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\d0-9]+")
    private String userPassword;


    @Override
    public String toString() {
        return "User[" +
                "Id=" + userId +
                ", Name='" + userName + '\'' +
                ", Email='" + userEmail + '\'' +
                ", Password='" + userPassword + '\'' +
                ']';
    }

}
