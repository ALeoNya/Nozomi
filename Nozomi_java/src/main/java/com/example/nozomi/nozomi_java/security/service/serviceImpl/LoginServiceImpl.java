package com.example.nozomi.nozomi_java.security.service.serviceImpl;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.LoginUser;
import com.example.nozomi.nozomi_java.pojo.Role;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import com.example.nozomi.nozomi_java.pojo.UserRole;
import com.example.nozomi.nozomi_java.security.SecurityConfig;
import com.example.nozomi.nozomi_java.security.service.LoginService;
import com.example.nozomi.nozomi_java.service.RoleService;
import com.example.nozomi.nozomi_java.service.UserRoleService;
import com.example.nozomi.nozomi_java.util.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private SecurityConfig securityConfig;
    @Resource
    UserRoleService userRoleService;
    @Resource
    RoleService roleService;
    @Override
    public ResponseDTO login(UserAuth user) {
        try {
            //AuthenticationManager进行用户验证
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            if(Objects.isNull(authenticate)){
                return new ResponseDTO(416,"任务代号4-1-7","...登录失败");
            }
            //使用userid生成token
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            String userId = loginUser.getUser().getId().toString();
            String jwt = JwtUtil.createJWT(userId);

            //通过userid查询role(从UserRole获取role_id,最后获取role
            UserRole userRole = userRoleService.selUserRoleByUserId(Integer.parseInt(userId));
            //获取auth
            Role role = new Role();
            role.setId(userRole.getRoleId());
            ResponseDTO res = roleService.selRoleById(role);
            Role role1 = (Role) res.getData();
            //authenticate存入redis
            //redisCache.setCacheObject("login:"+userId,loginUser);

            HashMap<String,String> map = new HashMap<>();
            map.put("token",jwt);
            map.put("status",role1.getRoleName());
            map.put("userId",userId);
            return new ResponseDTO(417,"欢迎回来,铁御",map);
        } catch (AuthenticationException e) {
            System.out.println(e);
            return new ResponseDTO(416,"任务代号4-1-7","请检查你的账号或密码...登录失败");
        }
    }
}
