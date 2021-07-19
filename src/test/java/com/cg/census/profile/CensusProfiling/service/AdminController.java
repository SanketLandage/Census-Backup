package com.cg.census.profile.CensusProfiling.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.repository.UserRepository;

@SpringBootTest
public class AdminController {
	
	@InjectMocks
	private AdminService adminService;
	
	@Mock
	private UserRepository userRepository;
	
	
	@Test
	public void addUser() {
		
	User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
	Mockito.when(userRepository.save(user)).thenReturn(user);	
	User userActual1 = adminService.addUser(user);		
		assertEquals( user.getUid(), userActual1.getUid());
	}
	
	
	@Test
	public void findByUId() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getUid(), userActual1.getUid());
	}
	
	
	@Test
	public void findByFirstName() {
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
		Mockito.when(userRepository.save(user)).thenReturn(user);	
		User userActual1 = adminService.addUser(user);	
		assertEquals( user.getFirstName(), userActual1.getFirstName());
	}
	
	
	@Test
	public void findByLastName() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getLastName(), userActual1.getLastName());
	}
	
	
	@Test
	public void findByAge() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getAge(), userActual1.getAge());
	}
	
	
	@Test
	public void findByEmail() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getEmail(), userActual1.getEmail());
	}
	
	
	@Test
	public void findByCity() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getCity(), userActual1.getCity());
	}
	
	
	@Test
	public void findUserByGender() {
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User userActual1 = adminService.addUser(user);
		assertEquals( user.getGender(), userActual1.getGender());
	}
	
	
	@Test
	public void deleteUserById() throws Exception{
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
		userRepository.deleteAllByuid(user.getUid());
		verify(userRepository, times(1)).deleteAllByuid(user.getUid());
	}
	
	
	@Test
	public void deleteUserByEmail() throws Exception{
		
		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
		userRepository.deleteUserByemail(user.getEmail());
		verify(userRepository, times(1)).deleteUserByemail(user.getEmail());
	}
	
	
	@Test
	public void getAllUsers() { 
		
		User user1 = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
		User user2 = new User(101,"tejas","kulkarni","male", "tejas123@gmail.com", "gysfsgf", 5, "bangalore", "graduate", 14, null);
		User user3 = new User(101,"sanketr","sathe","male", "sanket123@gmail.com", "ascgys", 6, "chennai", "graduate", 16, null);
		User user4 = new User(101,"malhar","kate","male", "malhar123@gmail.com", "fgaxgys", 7, "jharkand", "graduate", 18, null);
		
		List<User> userlist = new ArrayList<>();
		userlist.add(user1);
		userlist.add(user2);
		userlist.add(user3);
		userlist.add(user4);
		
		Mockito.when(userRepository.findAll()).thenReturn(userlist);
		List<User> actualUserList = adminService.findAllUsers();
		assertEquals( userlist.size(), actualUserList.size());
		verify(userRepository,times(1)).findAll();
			
	}
}