/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
//will uncomment when i have a workaround for ${BASE_URL} >  application.properties

//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//public class AppTest {
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    private String URL = "http://localhost:";
//
//    
//    //@Test
//    public void appHasAGreeting() {
//
//        ResponseEntity<String> response =
//                testRestTemplate.getForEntity(URL + this.port + "/",String.class);
//
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//
//    }
//}
