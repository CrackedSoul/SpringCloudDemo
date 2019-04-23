package cn.mastercom.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RestService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "feignServiceHiError")
    public String feignServiceHi(String name) {
        return restTemplate.getForObject("http://service-feign/api/interface?name="+name,String.class);
    }
    public String feignServiceHiError(String name){
        return "Hi "+name+",调用失败";
    }
}
