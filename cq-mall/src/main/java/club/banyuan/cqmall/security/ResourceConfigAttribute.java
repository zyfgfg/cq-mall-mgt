package club.banyuan.cqmall.security;

import club.banyuan.cqmall.dao.entity.UmsResource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;

public class ResourceConfigAttribute implements ConfigAttribute, GrantedAuthority {

    private String attribute;

    public ResourceConfigAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ResourceConfigAttribute(UmsResource umsResource) {
        this.attribute=umsResource.getId()+":"+umsResource.getName();
    }

    public String getAttribute() {
        return null;
    }

    public String getAuthority() {
        return null;
    }
}
