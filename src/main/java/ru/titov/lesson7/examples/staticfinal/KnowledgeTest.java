package ru.titov.lesson7.examples.staticfinal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class KnowledgeTest {
    @Test
    public void testAskQuestion() throws Exception {
        Knowledge knowledge = new Knowledge();
        String answer = knowledge.askQuestion("question?");
        Assertions.assertEquals(answer, "The answer to 'question?' is: 42");

        setFinalStaticField(Knowledge.class, "ANSWER", 41);
        answer = knowledge.askQuestion("question?");
        Assertions.assertEquals(answer, "The answer to 'question?' is: 41");
    }


    private static void setFinalStaticField(Class<?> clazz, String fieldName, Object value)
            throws ReflectiveOperationException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, value);
    }
}