package club.banyuan.cqmall.security;

import club.banyuan.cqmall.annotation.LoggerAnnotation;
import club.banyuan.cqmall.service.AdminService;
import club.banyuan.cqmall.service.TokenService;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${token.header}")
    private String header;

    @Value("${token.schema}")
    private String schema;

    @Autowired
    TokenService tokenService;

    @Autowired
    AdminService adminService;

    @LoggerAnnotation
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authentication = httpServletRequest.getHeader(header);
        if (!StrUtil.isBlank(authentication) && authentication.startsWith("Bearer")) {
            String token=authentication.substring(schema.length());
            String subject=tokenService.parseToken(token);
            UmsAdminDetails umsAdminDetails= (UmsAdminDetails) adminService.loadUserByUsername(subject);
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                    umsAdminDetails.getUsername(),umsAdminDetails.getPassword(),umsAdminDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
