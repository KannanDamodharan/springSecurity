package com.example.springSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Roles {

    @Id
    private int id;
    private String name;
}