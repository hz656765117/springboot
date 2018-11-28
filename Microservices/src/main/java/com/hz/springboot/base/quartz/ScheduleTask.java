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


        String  res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=2cd86251-5dbd-4858-a4b5-0b76aca12743");
        LOGGER.info("huangzhuo's wbf sign result{}",res);

        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=ed0b8b61-9d34-46db-8098-2092a32255e5");
        LOGGER.info("zhiyuan's wbf sign result{}",res);

        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=14ccb88b-2799-44e6-b2b0-9c4ea5b87669");
        LOGGER.info("zhiyuan's wqb sign result{}",res);

        LOGGER.info("test webhooks");
        LOGGER.info("test webhooks again");

    }

//    public static void main(String[] args) {
////        LOGGER.info("Hello world, i'm the king of the world!!!");
////        String res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=c9981905-01e0-4524-90bf-52195b150985");
////        LOGGER.info(res);
////        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=f24c40b8-582e-4bc7-bf85-7f14f97020f2");
////        LOGGER.info(res);
////        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=b41e2ab0-b83e-4c7b-9d1f-5fb0b038c862");
////        LOGGER.info(res);
////        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=afad2a4f-1924-414d-b078-eb9aa4cf10c9");
////        LOGGER.info(res);
////
////        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=f6ea0cd8-2c6e-4561-a769-4e9b73de6036");
////        LOGGER.info("huangzhuo's wbf sign result",res);
//
//
//
//
//        String  res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=2cd86251-5dbd-4858-a4b5-0b76aca12743");
//        LOGGER.info("huangzhuo's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=ed0b8b61-9d34-46db-8098-2092a32255e5");
//        LOGGER.info("zhiyuan's wbf sign result{}",res);
//
//        res = HttpUtil.get("https://wobaifu.10010.com/wc/memSign","WOWEALTH_JSESSIONID=14ccb88b-2799-44e6-b2b0-9c4ea5b87669");
//        LOGGER.info("zhiyuan's wqb sign result{}",res);
//
//
//
//    }

}
