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
        System.out.println(Boolean.valueOf(conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED")));


        if (conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED") == null || Boolean.valueOf(conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED"))) {
            return true;
        }

        return false;
    }
}
