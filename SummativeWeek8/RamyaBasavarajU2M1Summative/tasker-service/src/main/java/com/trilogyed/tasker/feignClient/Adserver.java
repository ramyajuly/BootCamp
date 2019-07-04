package com.trilogyed.tasker.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ad-service")
public interface Adserver {
    @GetMapping(value = "/ad")
    String getAd();
}
