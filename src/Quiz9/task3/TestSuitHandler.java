package Quiz9.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestSuitHandler {
 void run (Class<?> clazz) {
     if (!clazz.isAnnotationPresent(TestSuite.class)) {
         System.out.println("Class " + clazz.getName() + " isn't annotated");
         return;
     }
     String[] values = clazz.getAnnotation(TestSuite.class).value();
     Method[] methods = clazz.getMethods();


     for (String name : values) {
         boolean found = false;
         Method method = null;
         int i = 0;

         while (i < methods.length) {
             if (name.equals(methods[i].getName())) {
                 found = true;
                 method = methods[i];
                 break;
             }
             i++;
         }
         if (!found) {
             System.out.println("Method with name " + name + " doesn't exists or not public in class " + clazz.getName());
             continue;
         }

         int parameterCount = method.getParameterCount();
         String s = Modifier.toString(method.getModifiers());
         if (parameterCount == 0 && s.contains("public") && !s.contains("static")) {
             System.out.println("\t -- Method " + clazz.getName() + "." + name + " started --");

//                System.out.println(method.getParameterCount() + "/" + s + "/" + method.getReturnType());

             method.setAccessible(true);

             try {
                 method.invoke(clazz.newInstance());
             } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                 e.printStackTrace();
             }


             System.out.println("\t -- Method " + clazz.getName() + "." + name + " finished --");
             continue;
         }
         System.out.println("Method with name " + name + " doesn't exists or not public in class " + clazz.getName());
     }
 }
 }
