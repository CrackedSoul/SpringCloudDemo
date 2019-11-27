package cn.mastercom.cloud.ribbon.api;

import cn.mastercom.cloud.ribbon.service.RestService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RibbonApi {

    @Autowired
    RestService restService;

    @GetMapping("/interface")
    public String api() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return  "This is Ribbon From IP:"+inetAddress.getHostAddress()+" ,HostName:"+inetAddress.getHostName();
    }
    @GetMapping("/feignInterface")
    public String apiFeign(@RequestParam(value = "name", defaultValue = "forezp") String name){
        StringBuilder sb=new StringBuilder("This is Ribbon,Then use RestService call Feign Service:");
        sb.append("\t Response From Feign:");
        sb.append( restService.feignServiceHi(name));
        return sb.toString();
    }
}
