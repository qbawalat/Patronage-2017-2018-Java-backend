package org.kwalat.patronage.validators.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qba Walat
 * created on 13/01/2018
 */

public class InDateRangeValidator implements ConstraintValidator<InDateRange, Date> {

    private final SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    private InDateRange constraintAnnotation;

    @Override
    public void initialize(InDateRange constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(java.util.Date value, ConstraintValidatorContext context) {
        try {
            final Date min = dateParser.parse(constraintAnnotation.value());
            return value == null || (value.after(min));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}