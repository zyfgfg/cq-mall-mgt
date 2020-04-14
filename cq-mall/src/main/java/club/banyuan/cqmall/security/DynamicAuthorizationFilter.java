package club.banyuan.cqmall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

public class DynamicAuthorizationFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    DynamicSecurityMatadataSource dynamicSecurityMatadataSource;

    @Autowired
    public void setAccessDecisionManager(DynamicAccessDecisionManager decisionManager) {
        super.setAccessDecisionManager(decisionManager);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMatadataSource;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       FilterInvocation filterInvocation=new FilterInvocation(servletRequest,servletResponse,filterChain);
        InterceptorStatusToken interceptorStatusToken = super.beforeInvocation(filterInvocation);
        try {
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(),filterInvocation.getResponse());
        } finally {
            super.afterInvocation(interceptorStatusToken,null);
        }

    }

}
