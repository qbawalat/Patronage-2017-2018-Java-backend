package org.kwalat.patronage.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Qba Walat
 * created on 16/01/2018
 */

public class H2ServiceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            if (!conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED").equals("false")) {
                System.out.println("llllllllllllllllllh2");
                return true;
            }
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }
}
