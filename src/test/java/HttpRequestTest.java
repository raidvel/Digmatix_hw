import birthdates.BirthDateApp;

import org.junit.jupiter.api.Test;

import org.springframework.test.context.ContextConfiguration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;


import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration(classes = BirthDateApp.class)
public class HttpRequestTest {

    @Test
    void addNewPerson() throws Exception {
        System.out.println("Adding a new person");
        URL url = new URL("http://localhost:" + 8080 + "/persons");
        URLConnection conn = url.openConnection();
        HttpURLConnection con = (HttpURLConnection) conn;
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8; ");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String JsonString = "{\"birthDate\":\"2000-06-22\",\"name\":\"John McClane\"}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = JsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        //There is no input stream, because we dont get anything back!
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response);
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
