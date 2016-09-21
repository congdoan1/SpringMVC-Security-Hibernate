package com.fpt.university.toandc.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ToanQri on 9/20/2016.
 */
@Entity
@Table(name="`Role`")
public class Role {
    private long roleId;
    private String roleName;
    private Set<User> users;

    @Id
    @Column(name = "roleId")
    @GeneratedValue
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "roleName")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
