package com.beautifulharborbackstage.dao.job;

import com.beautifulharborbackstage.utils.MailUtil;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class MultithreadScheduleTask {

        private Logger logger = LoggerFactory.getLogger(MultithreadScheduleTask.class);

//        @Async
//        @Scheduled(fixedDelay = 1000*1000*1000)  //间隔1秒
//        public void first() throws InterruptedException {
//            System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//            System.out.println();
//            Thread.sleep(1000 * 10);
//        }
//
//        @Async
//        @Scheduled(fixedDelay = 2000*1000*1000)
//        public void second() {
//            System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
//            System.out.println();
//        }

        @Async
        @Scheduled(cron = "0 0 12 ? * SUN")
        public void thread() throws MessagingException {
            System.out.println("业绩报送任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName()+"\n");

            MailUtil.send_mail("910547570@qq.com","<h3 style='color:red'>店长zhangteng你好：</h3><b>本周的营业额为"+"0￥，其中客户充值总额为"+"0￥，消费总度为"+"0￥"+"</b>");
        }
    }