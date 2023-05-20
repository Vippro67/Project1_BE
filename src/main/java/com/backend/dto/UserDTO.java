package com.backend.dto;

import com.backend.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String _id;

    private String username;
        
    private String phoneNumber;
    
    private String email;
    
    private String fullName;

    public UserDTO(User user)
    {
        this._id=user.get_id();
        this.username=user.getUsername();
        this.phoneNumber=user.getPhoneNumber();
        this.email=user.getEmail();
        this.fullName=user.getFullName();

    }
}
