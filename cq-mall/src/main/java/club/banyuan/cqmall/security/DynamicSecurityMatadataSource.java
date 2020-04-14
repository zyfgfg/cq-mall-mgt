package club.banyuan.cqmall.security;

import club.banyuan.cqmall.dao.entity.UmsResource;
import club.banyuan.cqmall.service.ResourceService;
import cn.hutool.core.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DynamicSecurityMatadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    ResourceService resourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        List<UmsResource> umsResources = resourceService.selectAllResource();
        FilterInvocation filterInvocation = (FilterInvocation) o;
        String url = filterInvocation.getRequestUrl();
        String path = URLUtil.getPath(url);
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        final List<ConfigAttribute> collect = umsResources.stream().filter(t -> {
            return antPathMatcher.match(t.getUrl(), path);
        }).map(ResourceConfigAttribute::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
