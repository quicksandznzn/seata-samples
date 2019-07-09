package seata.samples.asset;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by zhangshuai@taoche.com on 2019/7/8
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AssetApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AssetApp.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebEnvironment(true);
        application.run(args);
    }
}
