package com.vlm.cityhall.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.CertificateOfDeathService;

@RestController
@RequestMapping("/CertificateOfDeath")
public class CertificateOfDeathResource {
    private final CertificateOfDeathService certificateOfDeathService;

    public CertificateOfDeathResource(CertificateOfDeathService certificateOfDeathService) {
        this.certificateOfDeathService = certificateOfDeathService;
    }
}
