package seata.samples.asset.assign.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@Component
public class RequestHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            requestTemplate.header("Seata-Xid", xid);
        }
    }
}
