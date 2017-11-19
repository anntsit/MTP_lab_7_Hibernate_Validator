package validation;

import validation.Insurance;

import javax.validation.*;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Person incCarrier1 = new Person("John", "Smith", 28, "asd@dd.en" );
        Person owner1 = new Person("Mary", "Koh", 19, "mary@dd.en" );
        Insurance insurance1 = new Insurance("1H33KL90", incCarrier1, 800, owner1);

        Person incCarrier2 = new Person("John", "Smith", 28, "111" ); // problem
        Person owner2 = new Person("Mary", "Koh", 19, "mary@dd.en" );
        Insurance insurance2 = new Insurance("1H33KL90", incCarrier2, 800, owner2);

        getInfo(insurance1);
        getInfo(insurance2);
    }

    public static boolean validateObject(Insurance inc){
        boolean isValid = true;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Insurance>> constraintViolations = validator.validate(inc);
        if (constraintViolations.size() >= 1) {
            isValid = false;
        }

        return isValid;
    }

    public static boolean getInfo(Insurance insurance){
        Metrix.start();
        boolean flag1= validateObject(insurance);
        Metrix.stop();
        if(flag1) System.out.println("Validation of this object is successfully completed");
        else System.out.println("There is a problem while validating this object");
        Metrix.getAllMetrics();
        System.out.println("");
        return true;
    }
}
