package com.vlm.cityhall.serviceRepo;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

	public ResponseEntity<String> signUp(Map<String, String> requestMap);
}
