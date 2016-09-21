package com.fpt.university.toandc.model;

import javax.persistence.*;

/**
 * Created by ToanQri on 9/20/2016.
 */
@Entity
@Table(name="`User`")
public class User {
    private long userId;
    private String username;
    private String password;
    private String name;
    private Role role;

    @Id
    @Column(name = "userId")
    @GeneratedValue
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
