package com.vlm.cityhall.ServiceImpl;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.vlm.cityhall.DAO.UserDao;
import com.vlm.cityhall.ENTITY.User;
import com.vlm.cityhall.SecurityConfig.JwtFilter;
import com.vlm.cityhall.SecurityConfig.JwtUtil;
import com.vlm.cityhall.SecurityConfig.UserDetailsServiceImpl;
import com.vlm.cityhall.Service.UserService;
import com.vlm.cityhall.constents.CityHallConstants;
import com.vlm.cityhall.utils.CityHallUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter jwtFilter;
	

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		log.info("Inside signup {}", requestMap);
		try {
		if(validateSignUpMap(requestMap)){
			User user = userDao.findByEmailId(requestMap.get("email"));
			if(Objects.isNull(user)) {
				userDao.save(getUserFromMap(requestMap));
				return CityHallUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
			}
			else {
				return CityHallUtils.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return CityHallUtils.getResponseEntity(CityHallConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
	}catch (Exception ex) {
		ex.printStackTrace();
	}
		return CityHallUtils.getResponseEntity(CityHallConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("firstName") && requestMap.containsKey("lastName")
		&& requestMap.containsKey("email") && requestMap.containsKey("password")
		&& requestMap.containsKey("birthDay") && requestMap.containsKey("birthPlace"))
		{
			return true;
		}
		return false;
	
	}
	
	
	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setFirstName(requestMap.get("firstName"));
		user.setLastName(requestMap.get("lastName"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setBirthDay(LocalDate.parse(requestMap.get("birthDay")) );
		user.setBirthPlace(requestMap.get("birthPlace"));
		user.setRole("Admin");
		return user;
	}

}
