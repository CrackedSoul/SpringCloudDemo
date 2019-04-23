package cn.mastercom.cloud.ribbon.api;

import cn.mastercom.cloud.ribbon.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RibbonApi {
    @Value("${server.port}")
    String port;

    @Autowired
    RestService restService;

    @GetMapping("/interface")
    public String api(@RequestParam(value = "name", defaultValue = "forezp") String name){
        return "hi " + name + " ,i am from RibbonApi,port:"+port ;
    }
    @GetMapping("/feignInterface")
    public String apiFeign(@RequestParam(value = "name", defaultValue = "forezp") String name){
        return restService.feignServiceHi(name);
    }
}
