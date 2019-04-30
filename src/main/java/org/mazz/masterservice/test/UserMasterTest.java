//package org.mazz.masterservice.test;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mazz.masterservice.entity.UserMasterEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.Assert;
//import org.springframework.web.client.HttpClientErrorException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class UserMasterTest {
//@Autowired
//private TestRestTemplate restTemplate;
//@LocalServerPort
//private int port;
//private String getRootUrl() {
//return "http://localhost:" + port;
//}
//@Test
//public void contextLoads() {
//}
//@Test
//public void testGetAllUsers() {
//HttpHeaders headers = new HttpHeaders();
//HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
//HttpMethod.GET, entity, String.class);
//Assert.assertNotNull(response.getBody());
//}
//@Test
//public void testGetUserById() {
//	UserMasterEntity user = restTemplate.getForObject(getRootUrl() + "/users/1", UserMasterEntity.class);
//System.out.println(user.getFirstName());
//Assert.assertNotNull(user);
//}
//@Test
//public void testCreateUser() {
//UserMasterEntity user = new UserMasterEntity();
//user.setEmail("admin@gmail.com");
//user.setFirstName("admin");
//user.setLastName("admin");
//user.setCreatedBy("admin");
//user.setUpdatedBy("admin");
//ResponseEntity<UserMasterEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, UserMasterEntity.class);
//Assert.assertNotNull(postResponse);
//Assert.assertNotNull(postResponse.getBody());
//}
//@Test
//public void testUpdatePost() {
//int id = 1;
//UserMasterEntity user = restTemplate.getForObject(getRootUrl() + "/users/" + id, UserMasterEntity.class);
//user.setFirstName("admin1");
//user.setLastName("admin2");
//restTemplate.put(getRootUrl() + "/users/" + id, user);
//UserMasterEntity updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, UserMasterEntity.class);
//Assert.assertNotNull(updatedUser);
//}
//@Test
//public void testDeletePost() {
//int id = 2;
//UserMasterEntity user = restTemplate.getForObject(getRootUrl() + "/users/" + id, UserMasterEntity.class);
//Assert.assertNotNull(user);
//restTemplate.delete(getRootUrl() + "/users/" + id);
//try {
//user = restTemplate.getForObject(getRootUrl() + "/users/" + id, UserMasterEntity.class);
//} catch (final HttpClientErrorException e) {
//Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//}
//}
//}
