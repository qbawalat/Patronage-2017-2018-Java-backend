package org.kwalat.patronage.validators.date;

import org.kwalat.patronage.model.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Qba Walat
 * created on 15/01/2018
 */
public class LegitDateOfIssueValidator implements ConstraintValidator<LegitDateOfIssue, Car> {
    @Override
    public void initialize(LegitDateOfIssue constraintAnnotation) {
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext context) {
        if (car.getRegistrationBookDateOfIssue().after(car.getFirstRegistrationDate())) {
            return true;
        }
        return false;

    }
}