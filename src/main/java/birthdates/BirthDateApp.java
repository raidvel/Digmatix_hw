package birthdates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BirthDateApp {
    public static void main(String[] args){
        SpringApplication.run(BirthDateApp.class, args);

        /*TODO:
           Create an actual database connection:
            DROP table at startup
            Create new from ddl_Person.sql
           Create tests for POST and validating its input from DB
           Create tests for GET and its subversions
           Create test for DELETE
        */
    }

}
