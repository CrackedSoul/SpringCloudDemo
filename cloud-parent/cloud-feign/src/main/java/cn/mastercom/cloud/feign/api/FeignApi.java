package cn.mastercom.cloud.feign.api;

import cn.mastercom.cloud.feign.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeignApi {
    @Value("${server.port}")
    String port;

    @Value("${cn.mastercom.cloud.name}")
    String mastercomName;

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/interface")
    public String api(@RequestParam(value = "name", defaultValue = "forezp") String name){
        return "hi " + name + " ,i am from FeignApi,port:"+port ;
    }
    @GetMapping("/name")
    public String apiName(@RequestParam(value = "name", defaultValue = "forezp") String name){
        return "hi " + name + " ,i am "+mastercomName+" from FeignApi,port:"+port ;
    }
    @GetMapping("/ribbonInterface")
    public String apiFeign(@RequestParam(value = "name", defaultValue = "forezp") String name){
        return ribbonService.ribbonServiceHi(name);
    }
}
