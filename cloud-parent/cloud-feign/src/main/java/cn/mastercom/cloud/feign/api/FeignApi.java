package cn.mastercom.cloud.feign.api;

import cn.mastercom.cloud.feign.service.RibbonService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeignApi {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/interface")
    public String api() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return  "This is Feign From IP:"+inetAddress.getHostAddress()+" ,HostName:"+inetAddress.getHostName();
    }

    @GetMapping("/ribbonInterface")
    public String apiFeign(@RequestParam(value = "name", defaultValue = "forezp") String name)
        throws UnknownHostException {
        StringBuilder sb=new StringBuilder("This is Feign,Then use FeignClient call Ribbon Service:");
        sb.append("\t Response From Ribbon:");
        sb.append( ribbonService.ribbonServiceHi(name));
        return sb.toString();
    }
}
