package com.cg.census.profile.CensusProfiling.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.census.profile.CensusProfiling.model.AppUser;
import com.cg.census.profile.CensusProfiling.secure.repository.AppUserRepository;
import com.cg.census.profile.CensusProfiling.secure.service.AppUserService;

@SpringBootTest
public class AppUserTest {

	@InjectMocks
	private AppUserService appuserService;
	
	@Mock
	private AppUserRepository appUserRepository;
	
	@Test
	public void  login()  {
		//LOG.info("login");
		AppUser obj= new AppUser("username","username");
		Mockito.when(appuserService.login(obj)).thenReturn(obj); // actual
		AppUser obj1 = appuserService.login(obj);
		assertEquals( obj.getUsername(), obj1.getUsername());	
	}
	
	@Test
	public void  register()  {
		//LOG.info("register");
		AppUser obj= new AppUser("admin","admin");
		Mockito.when(appuserService.register(obj)).thenReturn(obj); // actual
		AppUser obj1 = appuserService.register(obj);
		assertEquals( obj.getUsername(), obj1.getUsername());	
	}
	
	@Test
	public String logout() {
		AppUser obj = new AppUser();	
		Mockito.when(appUserRepository.save(obj)).thenReturn(obj);
		String obj2 = appuserService.logout();
		assertEquals(obj.getUsername(), obj2);
	 		return "User logged out successfully";
	}
	
}