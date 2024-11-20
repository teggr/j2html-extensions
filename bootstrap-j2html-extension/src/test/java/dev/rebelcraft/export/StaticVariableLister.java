package dev.rebelcraft.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StaticVariableLister {

    public static void generateStaticVariableCSV(String packageName, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.append("Value,Variable Name,Class Name,Package Name\n");

            Class[] classes = getClassesForPackage(packageName);
            for (Class<?> clazz : classes) {
                String className = clazz.getSimpleName();
                String classPackage = clazz.getPackage().getName();

                for (Field field : clazz.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        Object value = field.get(null); // Get the value of the static field
                        String variableName = field.getName();

                        // Write to CSV
                        writer.append(String.format("\"%s\",\"%s\",\"%s\",\"%s\"\n",
                                value, variableName, className, classPackage));
                    }
                }
            }
            System.out.println("CSV file generated: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Class[] getClassesForPackage(String packageName) throws ClassNotFoundException, IOException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');

        // Get both main and test directories
        URL mainClassesURL = new File("target/classes/" + path).toURI().toURL();
        URL testClassesURL = new File("target/test-classes/" + path).toURI().toURL();

        classes.addAll(findClasses(mainClassesURL, packageName));
        classes.addAll(findClasses(testClassesURL, packageName));

        return classes.toArray(new Class[0]);
    }

    private static List<Class<?>> findClasses(URL directoryURL, String packageName) throws ClassNotFoundException, MalformedURLException {
        List<Class<?>> classes = new ArrayList<>();
        File directory = new File(directoryURL.getPath());

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recurse into subdirectory
                        classes.addAll(findClasses(file.toURI().toURL(), packageName + "." + file.getName()));
                    } else if (file.getName().endsWith(".class")) {
                        // Add the class
                        String className = packageName + '.' + file.getName().replace(".class", "");
                        classes.add(Class.forName(className));
                    }
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        String packageName = "dev.rebelcraft.j2html.ext"; // Replace with your package
        String outputFilePath = "static_variables.csv"; // Specify the output CSV file path
        generateStaticVariableCSV(packageName, outputFilePath);
    }
}
