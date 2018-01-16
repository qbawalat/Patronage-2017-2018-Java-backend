package org.kwalat.patronage.conditions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Qba Walat
 * created on 16/01/2018
 */
@PropertySource("application.properties")
public class ServiceCondition implements Condition {

    @Value("${H2_STORAGE_ENABLED}")
    private boolean h2StorageEnabled;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println("SERVICE CONDITION: " + conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED"));
        if (Boolean.parseBoolean(conditionContext.getEnvironment().getProperty("H2_STORAGE_ENABLED"))) {
            return false;
        }
        return true;
    }
}
