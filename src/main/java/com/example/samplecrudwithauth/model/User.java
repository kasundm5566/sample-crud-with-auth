package com.example.samplecrudwithauth.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;
}
