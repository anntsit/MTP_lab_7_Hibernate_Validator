import org.junit.Before;
import org.junit.Test;
import validation.Insurance;
import validation.Person;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.*;

public class InsuranceTest {
    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void incCodeIsBiggerThanAllowed() {
        Person person = new Person("ann", "Smith", 20, "asd@dd.en");
        Insurance insurance = new Insurance("AD5U", person, 600.0, person);
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(insurance);
        assertEquals(1, constraintViolations.size());
    }
    @Test
    public void incCodeIsNull() {
        Person person = new Person("ann", "Smith", 20, "asd@dd.en");
        String incCode = null;
        Insurance insurance = new Insurance(incCode, person, 600.0, person);
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(insurance);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void incCarrierIsInvalid() {
        Person person = new Person("ann", "Smith", 20, "asd@dd.en");
        Person incCarrier = new Person("ann", "Smith", 200, "asd@dd.en");
        Insurance insurance = new Insurance("12GH56JK", person, 600.0, incCarrier);
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(insurance);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void costIsBiggerThanAllowed() {
        Person person = new Person("ann", "Smith", 20, "asd@dd.en");
        Insurance insurance = new Insurance("12GH56JK", person, 60.0, person);
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(insurance);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void costIsLessThanAllowed() {
        Person person = new Person("ann", "Smith", 20, "asd@dd.en");
        Insurance insurance = new Insurance("12GH56JK", person, 6000.0, person);
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(insurance);
        assertEquals(1, constraintViolations.size());
    }
}