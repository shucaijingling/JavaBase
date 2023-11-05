package com.shucai.registrar;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OperatorComponentRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {
    private Environment environment;
    private ResourceLoader resourceLoader;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        Set<String> basePackages = new HashSet<>();
        Map<String, Object> attributes = metadata.getAnnotationAttributes(EnableOperator.class.getName());
        for (String basePackage : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(basePackage)) {
                basePackages.add(basePackage);
            }
        }
        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(metadata.getClassName()));
        }

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider() {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                return true;
            }
        };
        scanner.setEnvironment(environment);
        scanner.setResourceLoader(resourceLoader);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Operator.class));

        for (String basePackage : basePackages) {
            Set<BeanDefinition> beanDefinitionSet = scanner.findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : beanDefinitionSet) {
                if (beanDefinition instanceof AnnotatedBeanDefinition) {
                    AnnotatedBeanDefinition definition = (AnnotatedBeanDefinition) beanDefinition;
                    AnnotationMetadata annotationMetadata = definition.getMetadata();
                    registrarOperatorComponent(annotationMetadata, registry);
                }
            }
        }
    }

    private void registrarOperatorComponent(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(OperatorFactoryBean.class);
        String className =metadata.getClassName();
        builder.addPropertyValue("type", className);
        Map<String, Object> attrs = metadata.getAnnotationAttributes(Operator.class.getName());
        builder.addPropertyValue("expression", attrs.get("value"));
        builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        try {
            beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, Class.forName(className));
        }catch (ClassNotFoundException e) {
            throw new BeanInstantiationException(this.getClass(), "setAttribute failed", e);
        }

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, className);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }
}
