package cn.mastercom.cloud.feign.service;

import cn.mastercom.cloud.feign.service.impl.FallRibbonService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-ribbon",fallback = FallRibbonService.class)
public interface RibbonService {
    @RequestMapping(value = "/api/interface",method = RequestMethod.GET)
    String ribbonServiceHi(@RequestParam(value = "name") String name);
}
