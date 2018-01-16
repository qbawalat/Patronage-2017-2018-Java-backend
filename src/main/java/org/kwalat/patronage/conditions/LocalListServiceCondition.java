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
        String h2Enabled = conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED");
        return h2Enabled != null && !Boolean.valueOf(h2Enabled);
    }
}
