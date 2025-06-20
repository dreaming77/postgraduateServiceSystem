
package me.zhengjie.config;

import lombok.Data;
import me.zhengjie.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ElAdminProperties {

    public static Boolean ipLocal;

    @Value("${ip.local-parsing}")
    public void setIpLocal(Boolean ipLocal) {
        ElAdminProperties.ipLocal = ipLocal;
    }
}
