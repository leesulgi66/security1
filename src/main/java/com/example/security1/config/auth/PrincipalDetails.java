package com.example.security1.config.auth;

// 시큐리티가 /login주소 요청이 오면 낚아채서  로그인을 진행시킨다.
// 로그인 진행이 완료가 되면 시큐리티 session을 만들어준다.(Security ContextHolder)
// 여기에 들어갈수 있는 Object는 정해져 있음 => Authentication 타입 객체
// Authentication 안에 User정보가 있어야 됨.
// 이 User 오브젝트 타입 => UserDetails 타입 객체

// Security Session => Authentication => UserDetails(PrincipalDetails)

import com.example.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user; //콤포지션

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    //해당 User의 권한을 리턴하는곳!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> colect = new ArrayList<>();
        colect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return colect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
