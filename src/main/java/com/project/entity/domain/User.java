package com.project.entity.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String lastname;
    private String email;

}
