package com.hz.springboot.base.quartz;

import com.hz.springboot.base.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask {
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
    public void sayHello(){
        LOGGER.info("Hello world, i'm the king of the world!!!");


//        String  res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=2cd86251-5dbd-4858-a4b5-0b76aca12743");
//        LOGGER.info("huangzhuo's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=5fa4cce0-1bb7-48dd-a0c8-12fb351a2ba1");
//        LOGGER.info("huangzhuo's wqb sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=ed0b8b61-9d34-46db-8098-2092a32255e5");
//        LOGGER.info("zhiyuan's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=14ccb88b-2799-44e6-b2b0-9c4ea5b87669");
//        LOGGER.info("zhiyuan's wqb sign result{}",res);
//
//        LOGGER.info("test webhooks");
//        LOGGER.info("test webhooks again");

    }

//    public static void main(String[] args) {
//
//
//        String  res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=2cd86251-5dbd-4858-a4b5-0b76aca12743");
//        LOGGER.info("huangzhuo's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=5fa4cce0-1bb7-48dd-a0c8-12fb351a2ba1");
//        LOGGER.info("huangzhuo's wqb sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=ed0b8b61-9d34-46db-8098-2092a32255e5");
//        LOGGER.info("zhiyuan's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=14ccb88b-2799-44e6-b2b0-9c4ea5b87669");
//        LOGGER.info("zhiyuan's wqb sign result{}",res);
//
//    }

}
