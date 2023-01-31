package com.vlm.cityhall.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.WeddingService;

@RestController
@RequestMapping("/Wedding")
public class WeddingResource {
    private final WeddingService weddingService;

    public WeddingResource(WeddingService weddingService) {
        this.weddingService = weddingService;
    }
}
