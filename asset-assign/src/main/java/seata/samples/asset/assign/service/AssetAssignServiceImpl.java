package seata.samples.asset.assign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seata.samples.asset.assign.sys.domain.AssetAssign;
import seata.samples.asset.assign.sys.repository.AssignRepository;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@Service
public class AssetAssignServiceImpl implements AssetAssignService {


    @Autowired
    AssignRepository assignRepository;

    @Override
    public void test() {
        AssetAssign assetAssign = assignRepository.findOne("14070e0e3cfe403098fa9ca37e8e7e76");
        assetAssign.setDesc("aad");
        assignRepository.save(assetAssign);
        throw new RuntimeException("test seata rollback");
    }
}
