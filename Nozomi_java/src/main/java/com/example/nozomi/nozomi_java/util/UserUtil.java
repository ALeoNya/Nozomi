package com.example.nozomi.nozomi_java.util;

import com.example.nozomi.nozomi_java.pojo.DTO.UserDetailsDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {
    /**
     * 静态方法，不需要初始化对象
     * @return
     */
    public static UserDetailsDTO getUserDetailsDTO() {
        return (UserDetailsDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
