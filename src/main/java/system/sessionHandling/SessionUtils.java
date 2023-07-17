package system.sessionHandling;

import javax.servlet.http.HttpSession;

public class SessionUtils {
    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttribute(HttpSession session, String attributeName, Class<T> targetType) {
        Object attributeValue = session.getAttribute(attributeName);
        if (attributeValue != null && targetType.isInstance(attributeValue)) {
            return (T) attributeValue;
        }
        return null;
    }
}

