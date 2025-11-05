package ek.osnb.demospringsecurity.app.model;

import jakarta.persistence.Entity;

@Entity
public class EntityAuthority extends BaseEntity{
   private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
