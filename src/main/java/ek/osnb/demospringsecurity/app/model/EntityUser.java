package ek.osnb.demospringsecurity.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class EntityUser extends BaseEntity {
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<EntityAuthority> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<EntityAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<EntityAuthority> authorities) {
        this.authorities = authorities;
    }
}
