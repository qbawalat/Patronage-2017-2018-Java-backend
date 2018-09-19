package org.kwalat.patronage.validators.date;

import org.kwalat.patronage.car.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Qba Walat
 * created on 15/01/2018
 */
public class ValidCarRegistrationDateValidator implements ConstraintValidator<ValidCarRegistrationDate, Car> {
    @Override
    public void initialize(ValidCarRegistrationDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext context) {
        if (car.getRegistrationBookDateOfIssue().after(car.getFirstRegistrationDate())) {
            return true;
        }
        return false;

    }
}