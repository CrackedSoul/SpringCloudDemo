package cn.mastercom.cloud.config.server.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {


  @GetMapping("/interface")
  public String api() throws UnknownHostException {
    InetAddress inetAddress = InetAddress.getLocalHost();
    return  "This is ConfigServer From IP:"+inetAddress.getHostAddress()+" ,HostName:"+inetAddress.getHostName();
  }
}
