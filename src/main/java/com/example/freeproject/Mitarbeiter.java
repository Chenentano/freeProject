package com.example.freeproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Mitarbeiter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mitarbeiter {
    @Id
    String ObjectID;
    int id;
    String name;
    int age;
    String description;
}
