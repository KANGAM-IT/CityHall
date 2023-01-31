package com.vlm.cityhall.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.cityhall.Service.CertificateOfBirthService;

@RestController
@RequestMapping("/CertificateOfBirth")
public class CertificateOfBirthResource {
    private final CertificateOfBirthService certificateOfBirthService;

    public CertificateOfBirthResource(CertificateOfBirthService certificateOfBirthService) {
        this.certificateOfBirthService = certificateOfBirthService;
    }
}
