import birthdates.BirthDateApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = BirthDateApp.class)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public URL url;

    {
        try {
            url = new URL("http://localhost:" + 8080 + "/management/persons");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void personsIsNotEmpty() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + 8080 + "/management/persons", String.class))
                .isNotEmpty();
    }

    @Test
    void addNewPerson() throws Exception {
        System.out.println("Adding a new person");

        URLConnection conn = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) conn;
        http.setRequestMethod("POST");
        http.setDoOutput(true);

        byte[] out = "{\"birthDate\":\"2000-06-22\",\"name\":\"John McClane\"}" .getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        System.out.println("Person: " + length);

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }


    @Test
    void getAllPersons() throws Exception {

    }
    @Test
    void getPersonById() throws Exception {

    }
    @Test
    void deletePersonById() throws Exception {

    }
    @Test
    void updatePersonById() throws Exception {

    }

}
