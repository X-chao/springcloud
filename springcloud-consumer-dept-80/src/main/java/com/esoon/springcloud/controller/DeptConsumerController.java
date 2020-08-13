package com.esoon.springcloud.controller;

import com.esoon.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DeptConsumerController {
    @Autowired
    private RestTemplate template;

//    这里配置生产者的端口信息
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return template.getForObject(REST_URL_PREFIX + "/dept/get" + id, Dept.class);
    }

}
