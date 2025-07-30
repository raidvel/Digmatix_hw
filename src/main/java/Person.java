import java.time.LocalDate;

public class Person {
    public long Id;
    public String Name;
    public LocalDate DateOfBirth;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }


}
