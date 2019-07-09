package seata.samples.asset.assign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seata.samples.asset.assign.service.AssetAssignService;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@RestController
public class TestController {

    @Autowired
    AssetAssignService assetAssignService;

    @GetMapping(value = "/test")
    public void test() {
        assetAssignService.test();
    }
}
