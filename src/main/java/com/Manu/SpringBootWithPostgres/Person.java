package com.Manu.SpringBootWithPostgres;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Table1")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment the value;
    private long id;
    private String name;
    private String email;
}
