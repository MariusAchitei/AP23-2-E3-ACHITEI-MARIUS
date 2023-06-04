package org.example;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputPath = "E:\\Java\\LAB12\\Compulsory\\src\\main\\java\\org\\example\\DummyClass.class"; // Replace with your input path

        List<Class<?>> testClasses = new ArrayList<>();

        // Step 1: Input Handling
        File inputFile = new File(inputPath);
        if (inputFile.isDirectory()) {
            processDirectory(inputFile, testClasses);
        } else if (inputPath.endsWith(".jar")) {
            processJarFile(inputFile, testClasses);
        }

        generatePrototypes(testClasses);

        executeTests(testClasses);

        printStatistics(testClasses);
    }

    private static void processDirectory(File directory, List<Class<?>> testClasses) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, testClasses);
                } else if (file.getName().endsWith(".class")) {
                    loadClassFromFile(file, testClasses);
                }
            }
        }
    }

    private static void processJarFile(File jarFile, List<Class<?>> testClasses) {
        // Extract .class files from the jar and process them
        // You can use a library like java.util.jar or Apache Commons Compress
    }

    private static void loadClassFromFile(File file, List<Class<?>> testClasses) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            String className = getClassNameFromPath(file.toPath());
            Class<?> clazz = loadClassFromBytes(className, bytes);
            testClasses.add(clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getClassNameFromPath(Path filePath) {
        String fileName = filePath.getFileName().toString();
        int extensionIndex = fileName.lastIndexOf(".class");
        String className = fileName.substring(0, extensionIndex);
        return className.replace(File.separator, ".");
    }

    private static Class<?> loadClassFromBytes(String className, byte[] bytes) {
        CustomClassLoader classLoader = new CustomClassLoader();
        return classLoader.loadClass(className, bytes);
    }

    private static void generatePrototypes(List<Class<?>> classes) {
        // Use a decompiler library like Javap to generate prototypes
        // You can invoke the Javap tool programmatically or use a third-party library
    }

    private static void executeTests(List<Class<?>> testClasses) {
        for (Class<?> clazz : testClasses) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        method.invoke(instance);
                    } catch (InstantiationException | IllegalAccessException
                             | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void printStatistics(List<Class<?>> testClasses) {
        int totalTests = 0;
        int passedTests = 0;

        for (Class<?> clazz : testClasses) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    totalTests++;
                    try {
                        Object instance = clazz.getDeclaredConstructor().newInstance();
                        method.invoke(instance);
                        passedTests++;
                    } catch (InstantiationException | IllegalAccessException
                             | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        double successRate = (double) passedTests / totalTests * 100;

        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + (totalTests - passedTests));
        System.out.println("Success Rate: " + successRate + "%");
    }

    private static class CustomClassLoader extends ClassLoader {
        public Class<?> loadClass(String className, byte[] classBytes) {
            return defineClass(className, classBytes, 0, classBytes.length);
        }
    }
}