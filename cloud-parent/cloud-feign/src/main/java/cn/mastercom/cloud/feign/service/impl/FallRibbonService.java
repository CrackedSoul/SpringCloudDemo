package cn.mastercom.cloud.feign.service.impl;

import cn.mastercom.cloud.feign.service.RibbonService;
import org.springframework.stereotype.Component;


@Component
public class FallRibbonService implements RibbonService {
    @Override
    public String ribbonServiceHi(String name) {
        return "Hi "+name+",调用失败";
    }
}
