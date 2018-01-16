package org.kwalat.patronage.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Qba Walat
 * created on 16/01/2018
 */

public class LocalListServiceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED") != null && !Boolean.getBoolean(conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED"))) {
            return true;
        }

        return false;
    }
}
