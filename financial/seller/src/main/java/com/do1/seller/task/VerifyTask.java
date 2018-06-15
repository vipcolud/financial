package com.do1.seller.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.do1.seller.enums.ChanEnum;
import com.do1.seller.service.VerifyService;

/**
 * 定时对账任务
 */
@Component
public class VerifyTask {
    @Autowired
    private VerifyService verifyService;

    //@Scheduled(cron = "0/5 * * * * ? ")
    public void hello(){
        System.out.println("hello");
    }

    @Scheduled(cron = "0 0 1,3,5 * * ? ")
    public void makeVerificationFile(){
        Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        for (ChanEnum chanEnum : ChanEnum.values()) {
            verifyService.makeVerificationFile(chanEnum.getChanId(),yesterday);
        }

    }

    @Scheduled(cron = "0 0 2,4,6 * * ? ")
    public void verify(){
        Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        for (ChanEnum chanEnum : ChanEnum.values()) {
            verifyService.verifyOrder(chanEnum.getChanId(),yesterday);
        }
    }
}