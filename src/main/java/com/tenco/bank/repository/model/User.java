package com.tenco.bank.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String uploadFileName;
    private String originFileName;
    private Timestamp createdAt;

    public String setUpUserImage() {
        return uploadFileName == null ?
                "https://picsum.photos/id/237/350"
                : "/images/uploads/" + uploadFileName;
    }

}