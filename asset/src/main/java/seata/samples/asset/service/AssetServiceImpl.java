package seata.samples.asset.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seata.samples.asset.sys.domain.Asset;
import seata.samples.asset.sys.repository.AssetRepository;
import seata.samples.asset.util.HttpUtil;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    AssetRepository assetRepository;


    @Override
    @GlobalTransactional(timeoutMills = 50000)
    public void test() {
        Asset asset = assetRepository.findOne("DF001");
        asset.setAmount(BigDecimal.valueOf(11122));
        //assetRepository.delete(asset);
        assetRepository.save(asset);
        System.out.println(RootContext.getXID());

        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("Seata-Xid", RootContext.getXID());
        Map<String, Object> params = new HashMap<String, Object>();
        String result = "";
        try {
            result = HttpUtil.httpGet("http://localhost:9998/asset-assign/test", headers, params);
        } catch (Exception e) {

        }
        System.out.println(result);
        if (result.contains("500")) {
            throw new RuntimeException("test seata rollback");
        }
    }
}
