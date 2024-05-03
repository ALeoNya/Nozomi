package com.example.nozomi.nozomi_java.pojo.DTO;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Component
/**
 * UserDetails用于封装用户信息，包括以下方法：
 * getAuthorities()
 * getPassword()
 * getPassword()
 * isAccountNonExpired()
 * isAccountNonLocked()
 * isCredentialsNonExpired()
 * isEnabled()
 */
public class UserDetailsDTO implements UserDetails {
    private UserAuth user;
    private List<String> permissions;  //存储权限信息

    public UserDetailsDTO(UserAuth user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    //存储SpringSecurity所需要的权限信息的集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities!=null){
            return authorities;
        }
        // 把permissions中字符串类型的权限信息转换成GrantedAuthority对象存入authorities中
        // 在后台查询到的权限为空时，自动在权限组中填入登录接口的权限
        authorities = permissions.stream().
                map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
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
