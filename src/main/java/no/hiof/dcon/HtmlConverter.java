package no.hiof.dcon;

import java.lang.reflect.Field;

/**
 * This class is used to perform conversions with Html format.
 */
public class HtmlConverter {

    private HtmlConverter() {
        throw new UnsupportedOperationException("HtmlConverter is a utility class and should not be instantiated.");
    }

    /**
     * Converts the given object to a Html file
     *
     * @param object The object to be converted to Bson document.
     * @return A string with the html code.
     */
    public static String htmlFromObject(Object object) {
        Class<?> clazz = object.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head><title>").append(clazz.getSimpleName()).append("</title></head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<table>");
        stringBuilder.append("<tr><th>Property</th><th>Value</th></tr>");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            stringBuilder.append("<tr>");
            stringBuilder.append("<td>").append(field.getName()).append("</td>");
            try {
                Object value = field.get(object);
                stringBuilder.append("<td>").append(value).append("</td>");
            } catch (Exception e) {
                stringBuilder.append("<td>").append("N/A").append("</td>");
            }
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("</table>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
