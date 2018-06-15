package com.do1.seller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.do1.seller.repositories.OrderRepository;
import com.do1.seller.service.VerifyService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 对账测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerifyTest {
    @Autowired
    private VerifyService verifyService;

    @Autowired
    private OrderRepository orderRepository;
    
    
    @Autowired
    @Qualifier("readorderRepository")
    private OrderRepository readOrderRepository;

    @Test
    public void makeVerificationTest(){
        Date day = new GregorianCalendar(2018,5,4).getTime();
        File file = verifyService.makeVerificationFile("111",day);
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void saveVerificationOrders() throws IOException{
        Date day = new GregorianCalendar(2018,5,4).getTime();
        verifyService.saveChanOrders("111",day);
    }
    @Test
    public void verifyTest(){
        Date day = new GregorianCalendar(2018,5,4).getTime();
        System.out.println(String.join(";", verifyService.verifyOrder("111", day)));
    }
    @Test
    public void queryOrder(){
        System.out.println("查询所有："+orderRepository.findAll());
       System.out.println(readOrderRepository.findAll());
    }

}