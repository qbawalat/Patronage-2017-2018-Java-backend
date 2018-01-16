package org.kwalat.patronage.validators.licence;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Qba Walat
 * created on 15/01/2018
 */
@Documented
@Constraint(validatedBy = LegitLicenceValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface LegitLicence {

    String message() default "{validation.licence.LegitLicence.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}