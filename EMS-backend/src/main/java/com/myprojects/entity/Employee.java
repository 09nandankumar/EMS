package com.myprojects.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_name")
    private String firstname;

    @Column(name = "Last_name")
    private String lastname;

    @Column(name = "Email_Id" , nullable = false,unique = true)
    private String email;

}
