package com.example.springSecurity.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class UserModel {

    @Id
    private String id;
    private String username;
    private String password;

    /*@DBRef
    private List<Roles> roles = new ArrayList<>();*/
}
