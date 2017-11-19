import org.junit.*;
import validation.Person;

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
    @Test
    public void nameIsNul() {
        String name = null;
        Person person = new Person(name, "Smith", 19, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void surnameIsBiggerThanAllowed() {
        Person person = new Person("ann", "SmithSmithSmithSmithSmithSmithSmith", 19, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void surnameIsNul() {
        String surname = null;
        Person person = new Person("ann", surname, 19, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void ageIsLessThanAllowed() {
        Person person = new Person("ann", "Smith", 0, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void ageIsBiggerThanAllowed() {
        Person person = new Person("ann", "Smith", 200, "asd@dd.en");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void emailIsNull() {
        String email = null;
        Person person = new Person("ann", "Smith", 19, email);
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void emailIsIncorrect() {
        Person person = new Person("ann", "Smith", 19, "123");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertEquals(1, constraintViolations.size());
    }
}