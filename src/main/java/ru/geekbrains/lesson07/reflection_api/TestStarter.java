package ru.geekbrains.lesson07.reflection_api;

import java.lang.reflect.Method;
import java.util.*;

public class TestStarter {
    private Class testStarter;
    private Map<String, List> testsMap = new HashMap<>();
    private List<Method> tests = new ArrayList<>();

    public TestStarter(Class testClass) {
        this.testStarter = testClass;
    }

    public void start() throws Exception {
        Method[] methods = testStarter.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                testsMap.computeIfAbsent(BeforeSuite.class.getSimpleName(), (k) -> new ArrayList()).add(m);
            }
            if (m.isAnnotationPresent(Test.class)) {
                testsMap.computeIfAbsent(Test.class.getSimpleName(), (k) -> new ArrayList()).add(m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                testsMap.computeIfAbsent(AfterSuite.class.getSimpleName(), (k) -> new ArrayList()).add(m);
            }
        }

        if (testsMap.getOrDefault(BeforeSuite.class.getSimpleName(), new ArrayList<>()).size() > 1)
            throw new Exception("ОШИБКА: Метод c аннотацией @BeforeSuite может быть вызван только один раз.");
        if (testsMap.getOrDefault(AfterSuite.class.getSimpleName(), new ArrayList<>()).size() > 1)
            throw new Exception("ОШИБКА: Метод c аннотацией @AfterSuite может быть вызван только один раз.");

        testsMap.getOrDefault(Test.class.getSimpleName(), new ArrayList<>()).sort(new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority();
            }
        });

        tests = testsMap.get(BeforeSuite.class.getSimpleName());
        if (tests != null && tests.size() > 0) {
            for (Method method : tests) {
                method.invoke(null);
            }
        }
        tests = testsMap.get(Test.class.getSimpleName());
        if (tests != null && tests.size() > 0) {
            for (Method method : tests) {
                method.invoke(null);
            }
        }
        tests = testsMap.get(AfterSuite.class.getSimpleName());
        if (tests != null && tests.size() > 0) {
            for (Method method : tests) {
                method.invoke(null);
            }
        }

        System.out.println(testsMap);
    }
}