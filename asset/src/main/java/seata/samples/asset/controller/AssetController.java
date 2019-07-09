package seata.samples.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seata.samples.asset.service.AssetService;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping(value = "/test")
    public void test() {
        assetService.test();
    }
}
