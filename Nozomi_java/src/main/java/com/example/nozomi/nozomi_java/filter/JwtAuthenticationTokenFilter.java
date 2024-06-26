package com.example.nozomi.nozomi_java.filter;

import com.example.nozomi.nozomi_java.mapper.RoleResourceMapper;
import com.example.nozomi.nozomi_java.mapper.UserAuthMapper;
import com.example.nozomi.nozomi_java.pojo.DTO.UserDetailsDTO;
import com.example.nozomi.nozomi_java.util.jwt.JwtUtil;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JWT过滤器
 * 位置在security之前？
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserAuthMapper userAuthMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        System.out.println("请求是否拥有Token ：" + StringUtils.hasText(token));
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        int userid;
        Map<String, Object> map = new HashMap<>();
        try {
            Claims claims = JwtUtil.parseJWT(token);
            //获取id
            userid = Integer.parseInt(claims.getId());
            // 将获取的权限信息封装到Authentication中
            List<String> permissionKeyList =  roleResourceMapper.listPermsByUserId(userid);
            System.out.println("权限信息为：" + permissionKeyList);
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userAuthMapper.selectById(userid),permissionKeyList);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetailsDTO,null, userDetailsDTO.getAuthorities());
            //存入SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            //放行
            filterChain.doFilter(request, response);
            //不抛出异常是因为抛出后会响应默认的Json覆盖掉MapToJson，但我也希望在控制台可以看到错误日志
        } catch (SignatureException e) {
            e.printStackTrace();
            map.put("code",401);
            map.put("msg", "无效签名");
            MapToJson.mapToJson(map,response);
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            map.put("code",401);
            map.put("msg", "不支持的签名");
            MapToJson.mapToJson(map,response);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            map.put("code",401);
            map.put("msg", "token过期");
            MapToJson.mapToJson(map,response);
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            map.put("code",401);
            map.put("msg", "不支持的签名格式");
            MapToJson.mapToJson(map,response);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            map.put("code",403);
            map.put("msg", "用户权限不足");
            MapToJson.mapToJson(map,response);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",401);
            map.put("msg", "token非法");
            MapToJson.mapToJson(map,response);
        }
    }
}