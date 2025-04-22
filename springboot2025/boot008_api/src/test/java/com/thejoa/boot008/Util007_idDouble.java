package com.thejoa.boot008;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot008.util7_iddouble.MyUser;
import com.thejoa.boot008.util7_iddouble.MyUserService;

@SpringBootTest
class Util007_idDouble {
	@Autowired MyUserService myUserService;
	
	@Disabled //@Test
	void userInsert() {
		MyUser user = new MyUser();
		//user.setUsername("first");
		//user.setEmail("first@gmail.com");
		user.setUsername("second");
		user.setEmail("second@gmail.com");
		System.out.println(myUserService.insertUser(user));
	}
	@Test
	void userSelectEmail() {
		System.out.println(myUserService.selectUseremail("first@gmail.com"));
	}
	@Disabled @Test 
	void userSelectUsername() {
		System.out.println(myUserService.selectUsername("first"));
	}
	
}
