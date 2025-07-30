package birthdates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BirthDateApp {
    public static void main(String[] args){
        System.setProperty("server.servlet.context-path", "/BirthDateApp");
        SpringApplication.run(BirthDateApp.class, args);
    }
}
