import org.junit.*;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameIsBiggerThanAllowed() {
        Person person = new Person("qwertyuiopasdfghjklz", "Smith", 19, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
}