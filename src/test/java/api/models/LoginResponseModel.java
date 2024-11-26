package api.models;

import lombok.Data;

@Data
public class LoginResponseModel {
    String userId;
    String token;
    String username;
    String password;
    String expires;
    String created_date;
    Boolean isActive;

}