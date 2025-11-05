package ek.osnb.demospringsecurity.security.users;

import ek.osnb.demospringsecurity.app.model.EntityAuthority;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {

    private final EntityAuthority authority;

    public CustomAuthority(EntityAuthority authority ) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
