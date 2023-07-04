package ui.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String phone;
    private String companyName;

    private String address;
    private String country;
    private String numberOfUsers;

}
