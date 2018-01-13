package org.kwalat.patronage.validators.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Qba Walat
 * created on 13/01/2018
 */
@Documented
@Constraint(validatedBy = InDateRangeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InDateRange {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    String currentDate = dateFormat.format(cal.getTime());

    String message() default "{validation.date.InDateRange.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String min() default "1900-01-01";

}