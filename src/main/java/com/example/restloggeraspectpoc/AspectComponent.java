package com.example.restloggeraspectpoc;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class AspectComponent {
    private static final List<Class<? extends Annotation>> mappings = List.of(
            GetMapping.class,
            PostMapping.class,
            PutMapping.class,
            PatchMapping.class,
            DeleteMapping.class
    );

    @Before("execution(* com.example.restloggeraspectpoc.*Controller.*(..))")
    public void logRestConsole(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final String sourceName = joinPoint.getTarget().getClass().getSimpleName();
        final String methodName = signature.getName();
        final Object[] args = joinPoint.getArgs();
        mappings.stream()
                .map(anotClass -> signature.getMethod().getAnnotation(anotClass))
                .filter(Objects::nonNull)
                .map(annotation -> annotation.annotationType().getSimpleName())
                .findFirst()
                .ifPresent(annot -> logRestMapping(sourceName, annot, methodName, args));
    }

    private void logRestMapping(final String sourceName, final String methodType, final String methodName, final Object[] methodArgs) {
        log.info("{} - REST {} {} : {}", sourceName, methodType, methodName, methodArgs);
    }
}
