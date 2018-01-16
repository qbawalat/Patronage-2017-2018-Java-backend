package org.kwalat.patronage.validators.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.Calendar;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Qba Walat
 * created on 13/01/2018
 */
@Documented
@Constraint(validatedBy = InDateRangeValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface InDateRange {


    Calendar cal = Calendar.getInstance();
    String currentDate = LocalDate.now().toString();

    String message() default "{validation.date.InDateRange.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();

    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        InDateRange[] value();
    }

}