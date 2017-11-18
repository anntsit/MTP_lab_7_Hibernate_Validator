import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
public class Insurance {
    @NotNull
    @Size(max = 8, min = 8)
    public String incCode;
    @Valid
    public Person incCarrier;
    @Valid
    public Person owner;
    @DecimalMax("5000.0")
    @DecimalMin("500.0")
    public double cost;

    public Insurance(String code,Person owner, double cost, Person incCarrier ){
        incCode = code;
        this.owner = owner;
        this.cost = cost;
        this.incCarrier = incCarrier;
    }
}
