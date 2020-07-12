package com.autosell.domains;

import com.autosell.annotations.EmailUnique;
import com.autosell.annotations.UserNameUnique;
import com.autosell.configs.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 4,max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 4,max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 4,max = 50)
    @UserNameUnique
    private String userName;

    @NotBlank
    @Size(min = 4,max = 50)
    private String password;


    @NotBlank
    @Email
    @EmailUnique
    private String email;

    private boolean adminVerification;

    private Short userStatus = 0;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Authority> authorities;

    public User() {
        authorities = new ArrayList<Authority>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdminVerification() {
        return adminVerification;
    }

    public void setAdminVerification(boolean adminVerification) {
        this.adminVerification = adminVerification;
    }

    public Short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Short userStatus) {
        this.userStatus = userStatus;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(RoleEnum roleEnum) {
        this.authorities.add(new Authority(this,roleEnum));
    }
}
