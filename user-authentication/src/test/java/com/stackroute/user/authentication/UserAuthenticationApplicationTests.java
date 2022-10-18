//package com.stackroute.user.authentication;
//
//import com.stackroute.user.authentication.entity.UserAuthentication;
//
//import com.stackroute.user.authentication.service.JwtUserDetailsService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.junit.Assert.assertEquals;
//
//@SpringBootTest
//class UserAuthenticationApplicationTests {
//	@Autowired
//	JwtUserDetailsService jwtUserDetailsService;
//
//	@Test
//	void contextLoads() {
//
//	}
//	@Test
//	void add()
//	{
//		assertEquals(2,2);
//	}
//	@Test
//	void RegistrationValidations(UserAuthentication userAuthentication) throws UserAlreadyExist {
//		UserAuthentication userAuthentication1=new UserAuthentication("rameshbabu@gmail.com","RameshBabu@1");
////    userAuthentication1.setEmailId("rameshbabu@gmail.com");
////	userAuthentication1.setPassword("RameshBabu@1");
//	UserAuthentication savedUser=this.jwtUserDetailsService.addUser(userAuthentication1);
//		assertThat(savedUser).isNotNull();
//	assertThrows(UserAlreadyExist.class, (Executable) this.jwtUserDetailsService.addUser(userAuthentication1),"user alredy exisisted");
//
//		try {
//			assertEquals("rahulbabu@gmail.com", jwtUserDetailsService.addUser(userAuthentication1).getEmailId());
//			assertEquals("RahulBabu@1", jwtUserDetailsService.addUser(userAuthentication1).getPassword());
//		} catch (UserAlreadyExist e) {
//			throw new RuntimeException(e);
//		}
//
//	}
//	@Test
//	void checkingJwtToken()
//	{
//	//	assertEquals("",this.jwtUserDetailsService.loadUserByUsername("ccc@gmail.com"));
//		assertEquals("[UserAuthentication(emailId=aaa@gmail.com, password=aaa), UserAuthentication(emailId=bbb@gmail.com, password=bbb), UserAuthentication(emailId=ccc@gmail.com, password=ccc), UserAuthentication(emailId=ddd@gmail.com, password=ddd), UserAuthentication(em ...\n"
//				,this.jwtUserDetailsService.getAllUsers());
//	}
//
//	@Test
//	public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception, UserAlreadyExist {
//		UserAuthentication userAuthentication1=new UserAuthentication("rameshbabu1@gmail.com","RameshBabu@11","User");
//		UserAuthentication result = this.jwtUserDetailsService.addUser(userAuthentication1);
//				//.getForEntity("/private/hello", String.class);
//		assertEquals(HttpStatus.OK, result.getStatusCode());
//		assertEquals("RameshBabu@11", result.getPassword());
//	}
//
//}
