package org.kwalat.patronage.validators.licence;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Qba Walat
 * created on 15/01/2018
 */
public class LegitLicenceValidator implements ConstraintValidator<LegitLicence, String> {
    private LegitLicence constraintAnnotation;

    @Override
    public void initialize(LegitLicence constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String licenceNumber, ConstraintValidatorContext context) {
        if (licenceNumber.charAt(0) != licenceNumber.charAt(1)) {
            for (int i = 2; i < licenceNumber.length() - 1; i++) {
                if (!Character.isDigit(licenceNumber.charAt(i))) {
                    return false;
                }
            }
            return Character.isUpperCase(licenceNumber.charAt(0)) && Character.isUpperCase(licenceNumber.charAt(1));
        }
        return false;
    }
}