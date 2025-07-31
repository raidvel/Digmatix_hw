package birthdates;

import controller.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackageClasses = PersonController.class)
public class BirthDateApp {
    public static void main(String[] args){
        SpringApplication.run(BirthDateApp.class, args);

        /*TODO:
           Create an actual database connection:
            DROP table at startup
            Create new from ddl_Person.sql
        */
    }

}
