//package com.cg.census.profile.CensusProfiling.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.cg.census.profile.CensusProfiling.model.User;
//import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
//import com.cg.census.profile.CensusProfiling.repository.UserFamilyMemberRepository;
//import com.cg.census.profile.CensusProfiling.repository.UserRepository;
//
//public class UserController {
//	
//	@InjectMocks
//	private UserService userService;
//	private AdminService adminService;
//	
//	@Mock
//	private UserFamilyMemberRepository userfamilymemberRepository;
//	private UserRepository userRepository;
//	
//	@Test
//	public void addUser() {
//		
//	User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
//	Mockito.when(userRepository.save(user)).thenReturn(user);	
//	User userActual1 = adminService.userRegister(user);		
//		assertEquals( user.getUid(), userActual1.getUid());
//	}
//
////	public void updateUserProfile() {
////		
////		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);
////		Mockito.when(userfamilymemberRepository.save(user)).thenReturn(user);	
////		User userActual1 = adminService.userRegister(user, "aditya");		
////			assertEquals( user.getUid(), userActual1.getUid());
////		}
//	
//	
////	@Test
////	public void addFamilyMemberInfo() {
////		
////		UserFamilyMember userfamilymember = new UserFamilyMember(101,"dekar", "kulkarni", "male", "brother", 31, "Graduate", user);
////		Mockito.when(userfamilymemberRepository.save(userfamilymember)).thenReturn(userfamilymember);	
////		UserFamilyMember userfamilymember1  = userService.updateMemberInfo( userfamilymember);		
////			assertEquals(  userfamilymember.getMemFirstName(),  userfamilymember1.getMemFirstName());
////
////}
//	
//	
//	
////	@Test
////	public void updateUserFamilyMemberInfo() {
////		
////		UserFamilyMember userfamilymember = new UserFamilyMember(101,"dekar", "kulkarni", "male", "brother", 31, "Graduate", user);
////		Mockito.when(userfamilymemberRepository.save(userfamilymember)).thenReturn(userfamilymember);	
////		UserFamilyMember userfamilymember1  = userService.updateMemberInfo( userfamilymember);		
////			assertEquals(  userfamilymember.getMemFirstName(),  userfamilymember1.getMemFirstName());
////
////}
//	
//	@Test
//	public void findFamilyMemberByFirstName() {
//		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
//		Mockito.when(userRepository.save(user)).thenReturn(user);	
//		User userActual1 = adminService.userRegister(user);	
//		assertEquals( user.getFirstName(), userActual1.getFirstName());
//	}
//	
//	@Test
//	public void findFamilyMemberByRelation() {
//		User user = new User(101,"aditya","kamath","male", "aditya123@gmail.com", "gys", 2, "pune", "graduate", 12, null);	
//		Mockito.when(userRepository.save(user)).thenReturn(user);	
//		User userActual1 = adminService.userRegister(user);	
//		assertEquals( user.getFirstName(), userActual1.getFirstName());
//	}
//	
////	@Test
////	public void findFamilyMemberById() {
////		UserFamilyMember userfamilymember = new UserFamilyMember(101,"dekar", "kulkarni", "male", "brother", 31, "Graduate", );
////		Mockito.when(userRepository.save(userfamilymember)).thenReturn(userfamilymember);	
////		UserFamilyMember userfamilymember1 = userService.findMemberById(userfamilymember);	
////		assertEquals( userfamilymember.getMemId(),userfamilymember1.getMemId());
////	}
//	
////	@Test
////	public void deleteMemberByFirstName() throws Exception{
////		
////		UserFamilyMember userfamilymember = new UserFamilyMember(101,"dekar", "kulkarni", "male", "brother", 31, "Graduate", );
////		userfamilymemberRepository.deleteBymemFirstName(userfamilymember.getMemFirstName());
////		verify(userfamilymemberRepository, times(1)).deleteBymemFirstName((userfamilymember.getMemFirstName()));
////	}
//	
////	@Test
////	public void deleteMemberById() throws Exception{
////		
////		UserFamilyMember userfamilymember = new UserFamilyMember(101,"dekar", "kulkarni", "male", "brother", 31, "Graduate", user);
////		userfamilymemberRepository.deleteById(userfamilymember.getMemId());
////		verify(userfamilymemberRepository, times(1)).deleteById((userfamilymember.getMemId()));
////	}
////	
//	
//	
//}