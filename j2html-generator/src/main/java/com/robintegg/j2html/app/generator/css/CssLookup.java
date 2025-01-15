package com.robintegg.j2html.app.generator.css;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.CssClassMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class CssLookup {

    private Map<String, CssClassReference> cssClassReferencesByCssClass = new HashMap<>();

    @PostConstruct
    public void init() {

        // find all the annotations on a class
        Class<?> clazz = Bootstrap.class;

        // Iterate over all fields in the class
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName());

            // Iterate over all annotations on the field
            for (Annotation annotation : field.getAnnotations()) {
                System.out.println("  Annotation: " + annotation.annotationType().getName());
                if(annotation instanceof CssClassMapper) {
                    cssClassReferencesByCssClass.put(
                            ((CssClassMapper) annotation).className(),
                            new CssClassReference(
                                    ((CssClassMapper) annotation).className(),
                                    ((CssClassMapper) annotation).field(),
                                    clazz.getSimpleName(),
                                    clazz.getPackageName()
                            )
                    );
                }
            }
        }

            // Print the map to verify
            cssClassReferencesByCssClass.forEach((key, record) ->
                    System.out.println("Key: " + key + ", Record: " + record)
            );
    }

    public StaticVariableReference getStaticVariableReference( String className ) {

        if(cssClassReferencesByCssClass.containsKey(className)) {
            CssClassReference cssClassReference = cssClassReferencesByCssClass.get(className);
            return new StaticVariableReference() {
                @Override
                public String getPackageName() {
                    return cssClassReference.packageName();
                }

                @Override
                public String getClassName() {
                    return cssClassReference.className();
                }

                @Override
                public String getVariableName() {
                    return cssClassReference.variableName();
                }
            };
        }

        return null;

    }

}
