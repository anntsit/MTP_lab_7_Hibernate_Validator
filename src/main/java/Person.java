import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Person {
    @NotNull
    @Size(max = 15)
    public String name;
    @NotNull
    @Size(max = 30)
    public String surname;
    @Min(1)
    @Max(130)
    public int age;
    @NotNull
    @Email
    public String email;

    public Person(String name, String surname, int age, String email){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
}
