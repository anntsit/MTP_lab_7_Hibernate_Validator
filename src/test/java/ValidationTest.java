import org.junit.Test;
import validation.Insurance;
import validation.Main;
import validation.Person;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void validateObject()  {
        Person incCarrier1 = new Person("John", "Smith", 28, "asd@dd.en" );
        Person owner1 = new Person("Mary", "Koh", 19, "mary@dd.en" );
        Insurance insurance1 = new Insurance("1H33KL90", incCarrier1, 800, owner1);
        assertEquals(true, Main.validateObject(insurance1));

    }

    @Test
    public void getInfo()  {
        Person incCarrier1 = new Person("John", "Smith", 28, "asd@dd.en" );
        Person owner1 = new Person("Mary", "Koh", 19, "mary@dd.en" );
        Insurance insurance1 = new Insurance("1H33KL90", incCarrier1, 800, owner1);
        assertTrue( Main.getInfo(insurance1));
    }

}