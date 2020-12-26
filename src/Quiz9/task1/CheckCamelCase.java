package Quiz9.task1;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "[a-z]+((\\\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";

    public static boolean checkAndPrint(Class clazz) {
        Method[] method = clazz.getMethods(); // all methods in our array from clazz
        Pattern pattern = Pattern.compile(CAMELCASE_PATTERN);

        boolean result = true;

        for (Method methods : method) {
            if (methods.isAnnotationPresent(CamelCase.class)) {
                String name = methods.getName();
                if (!pattern.matcher(name).matches()) {
                    System.out.println("method " + clazz.getName() + "." + methods.getName() + " doesn't satisfy camelCase naming convention");
                    result = false;
                }
            }
        }

        return result;
    }
}
