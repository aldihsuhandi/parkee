package id.parkee.test.boot;

import id.parkee.test.common.model.constant.LoggerConstant;
import id.parkee.test.core.configuration.ParkeeConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EntityScan("id.parkee.test")
@ComponentScan("id.parkee.test")
public class ParkeeApplication {

    private static final Logger logger = LoggerFactory.getLogger(LoggerConstant.SERVER_BOOT);

    public static void main(String[] args) {
        try {

            String appHome = System.getProperty("user.dir");
            logger.info(ParkeeApplication.class.getSimpleName() + " is running at location: " + appHome);
            long current = System.currentTimeMillis();

            SpringApplication springApplication = new SpringApplication(ParkeeConfiguration.class);
            ApplicationContext applicationContext = springApplication.run(args);

            Environment environment = applicationContext.getEnvironment();

            String appName = environment.getProperty("app.name");
            String profiles = environment.getProperty("spring.profiles.active");
            logger.info(ParkeeApplication.class.getSimpleName() + " loaded appName: " + appName);
            logger.info(ParkeeApplication.class.getSimpleName() + " loaded active profiles: " + profiles);


            long timeCost = System.currentTimeMillis() - current;
            logger.info(String.format("parkee application started in %dms, loaded %d beans:", timeCost, applicationContext.getBeanDefinitionCount()));

            for (String beanName : applicationContext.getBeanDefinitionNames()) {
                Object bean = applicationContext.getBean(beanName);
                Class<?> targetClass = AopUtils.getTargetClass(bean);
                if (targetClass.getName().startsWith("id.parkee.test")) {
                    logger.info(String.format("\t >>> %s : %s", beanName, targetClass.getName()));
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause(), e);
        }
    }
}
